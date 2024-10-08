package com.RetrieveOrders.Retrieve.Orders.Controller;

import com.RetrieveOrders.Retrieve.Orders.Config.JwtUtils;
import com.RetrieveOrders.Retrieve.Orders.Entity.ReplenishOrder;
import com.RetrieveOrders.Retrieve.Orders.Service.ReplenishOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/replenish-orders")
@RequiredArgsConstructor
@Slf4j
public class ReplenishOrderController {

    @Autowired
    private final ReplenishOrderService replenishOrderService;


    @GetMapping("/orders")
    public ResponseEntity<List<ReplenishOrder>> getOrders(
            @RequestParam(required = false) String status,
            @RequestHeader("Authorization") String token) {

        log.info("Parse JWT token to extract user info");
        String role = JwtUtils.getRoleFromToken(token);
        String userId = JwtUtils.getUserIdFromToken(token);
        log.info("Call service to get filtered orders");


        if (role == null || userId == null) {
            log.error("Token parsing failed");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        System.out.println("Role: " + role + ", User ID: " + userId);

        List<ReplenishOrder> orders = replenishOrderService.getOrdersByRoleAndStatus(role, userId, status);

        return ResponseEntity.ok(orders);
    }

}
