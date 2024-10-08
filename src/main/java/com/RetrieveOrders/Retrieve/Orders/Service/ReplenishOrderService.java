package com.RetrieveOrders.Retrieve.Orders.Service;

import com.RetrieveOrders.Retrieve.Orders.Entity.ReplenishOrder;

import java.util.List;

public interface ReplenishOrderService {

   List<ReplenishOrder> getOrdersByRoleAndStatus (String role,String userId,String status);

}
