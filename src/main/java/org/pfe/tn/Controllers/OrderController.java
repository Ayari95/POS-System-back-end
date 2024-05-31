package org.pfe.tn.Controllers;

import org.pfe.tn.Repositories.OrderRepository;
import org.pfe.tn.Services.IOrderService;
import org.pfe.tn.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
@CrossOrigin("*")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id)
                .orElseThrow(() -> new IllegalArgumentException("Order not found with id: " + id));
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
        return orderService.updateOrder(id, order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

    @GetMapping("/total-transaction-amount-by-month")
    public Map<String, Double> getTotalTransactionAmountByMonth() {
        List<Order> orders = orderRepository.findAll();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM");

        // Initialize the map with all months from January to December set to 0
        Map<String, Double> monthlyTransactions = new LinkedHashMap<>();
        for (Month month : Month.values()) {
            String monthName = month.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
            monthlyTransactions.put(monthName, 0.0);
        }

        // Group orders by month and calculate the total transaction amount
        Map<String, Double> transactions = orders.stream()
                .filter(order -> {
                    ZonedDateTime zonedDateTime = Instant.ofEpochMilli(order.getOrderDate().getTime()).atZone(ZoneId.systemDefault());
                    return zonedDateTime.getYear() == LocalDate.now().getYear(); // Only include orders from the current year
                })
                .collect(Collectors.groupingBy(
                        order -> {
                            ZonedDateTime zonedDateTime = Instant.ofEpochMilli(order.getOrderDate().getTime()).atZone(ZoneId.systemDefault());
                            return zonedDateTime.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
                        },
                        Collectors.summingDouble(order -> order.getPrice() * order.getAmount())
                ));

        // Update the initialized map with the actual transaction amounts
        transactions.forEach(monthlyTransactions::put);

        return monthlyTransactions;
    }


}
