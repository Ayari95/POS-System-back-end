package org.pfe.tn.Services;

import org.pfe.tn.Repositories.OrderRepository;
import org.pfe.tn.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class IOrdersServiceImp implements IOrderService{

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order createOrder(Order order) {
        order.setOrderDate(new Date()); // Set the current date and time
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order updatedOrder) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isPresent()) {
            Order existingOrder = optionalOrder.get();
//            existingOrder.setClient(updatedOrder.getClient());
//            existingOrder.setProduct(updatedOrder.getProduct());
            existingOrder.setPrice(updatedOrder.getPrice());
            existingOrder.setInventoryStatus(updatedOrder.getInventoryStatus());
            existingOrder.setAmount(updatedOrder.getAmount());
            return orderRepository.save(existingOrder);
        } else {
            throw new IllegalArgumentException("Order not found with id: " + id);
        }
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

}
