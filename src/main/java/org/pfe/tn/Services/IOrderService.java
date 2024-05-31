package org.pfe.tn.Services;

import org.pfe.tn.entities.Order;

import java.util.List;
import java.util.Optional;


public interface IOrderService  {
    void deleteOrder(Long id);
    Order updateOrder(Long id, Order updatedOrder);
    Order createOrder(Order order);
    Optional<Order> getOrderById(Long id);
    List<Order> getAllOrders();
}
