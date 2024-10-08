package com.RetrieveOrders.Retrieve.Orders.Service.Impl;

import com.RetrieveOrders.Retrieve.Orders.Config.JwtUtils;
import com.RetrieveOrders.Retrieve.Orders.Entity.ReplenishOrder;
import com.RetrieveOrders.Retrieve.Orders.Reposotries.ReplenishOrderReposotries;
import com.RetrieveOrders.Retrieve.Orders.Service.ReplenishOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class ReplenishOrderServiceImpl implements ReplenishOrderService {

       @Autowired
       private final ReplenishOrderReposotries replenishOrderReposotries;


    @Override
    public List<ReplenishOrder> getOrdersByRoleAndStatus(String role, String userId, String status) {

        log.info("checking the role and userId and status of call");
        if (role == null || userId == null || status == null) {
            throw new IllegalArgumentException("Role, User ID, and Status cannot be null");
        }


        List<ReplenishOrder> orders=new ArrayList<>();

        switch (role) {
            case "SALES_AGENT":
                orders = replenishOrderReposotries.findByCreatedByAndStatus(userId, status);
                break;
            case "DELIVERY_AGENT":
                orders = replenishOrderReposotries.findByAssignedToAndStatus(userId, status);
                break;
            case "SHOPKEEPER":
                orders = replenishOrderReposotries.findByBelongsToAndStatus(userId, status);
                break;
            default:
                System.out.println("User role not recognized");
        }
        return orders;
    }


    public void validateToken(String token) {
        String role = JwtUtils.getRoleFromToken(token);
        String userId = JwtUtils.getUserIdFromToken(token);
        if (role == null || userId == null) {
            throw new IllegalArgumentException("Token is invalid or expired.");
        }
        System.out.println("Role: " + role + ", User ID: " + userId);
    }







}
