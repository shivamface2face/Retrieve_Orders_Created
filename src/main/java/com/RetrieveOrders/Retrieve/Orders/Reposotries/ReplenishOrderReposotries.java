package com.RetrieveOrders.Retrieve.Orders.Reposotries;

import com.RetrieveOrders.Retrieve.Orders.Entity.ReplenishOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ReplenishOrderReposotries extends JpaRepository<ReplenishOrder,Long> {

    // Query to get orders created by a specific Sales Agent
    List<ReplenishOrder> findByCreatedByAndStatus(String createdBy, String status);

    // Query to get orders assigned to a Delivery Agent
    List<ReplenishOrder> findByAssignedToAndStatus(String assignedTo, String status);

    // Query to get orders that belong to a Shopkeeper
    List<ReplenishOrder> findByBelongsToAndStatus(String belongsTo, String status);
}
