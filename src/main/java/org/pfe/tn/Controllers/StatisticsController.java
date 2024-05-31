package org.pfe.tn.Controllers;

import org.pfe.tn.Repositories.OrderRepository;
import org.pfe.tn.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.pfe.tn.Repositories.ClientRepository;
import org.pfe.tn.Repositories.ProductRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/stats")
@RestController
@CrossOrigin("*")
public class StatisticsController {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ClientRepository clientRepository ;
    @Autowired
    OrderRepository orderRepository ;


    @GetMapping
    public List<Integer> getStats() {

        LocalDate today = LocalDate.now();
        LocalDate oneWeekAgo = today.minusWeeks(1);
        LocalDate threeMonthsAgo = today.minusMonths(3);

        int productsTotal = this.productRepository.findAll().size();
        int clientTotal = this.clientRepository.findAll().size();
        int orderTotal = this.orderRepository.findAll().size();
        int categoryTotal = this.productRepository.findAll().stream()
                .map(Product::getCategory).filter(category -> !category.isEmpty()).distinct().toArray().length;
        double totalTransactions = this.orderRepository.findAll()
                .stream()
                .mapToDouble(order -> order.getAmount() * order.getPrice())
                .sum();

        double totalTransactionToday = this.orderRepository.findAll()
                .stream()
                .filter(order -> order.getOrderDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().equals(today))
                .mapToDouble(order -> order.getAmount() * order.getPrice())
                .sum();

        double transactionsLastWeek = this.orderRepository.findAll()
                .stream()
                .filter(order -> order.getOrderDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().isAfter(oneWeekAgo))
                .mapToDouble(order -> order.getAmount() * order.getPrice())
                .sum();

        double transactionsLastThreeMonths = this.orderRepository.findAll()
                .stream()
                .filter(order -> order.getOrderDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().isAfter(threeMonthsAgo))
                .mapToDouble(order -> order.getAmount() * order.getPrice())
                .sum();

        List<Integer> res = new ArrayList<>();
        res.add(productsTotal);
        res.add(clientTotal);
        res.add(categoryTotal);
        res.add(orderTotal);
        res.add((int) totalTransactions);
        res.add((int) totalTransactionToday);
        res.add((int) transactionsLastWeek);
        res.add((int) transactionsLastThreeMonths);
        return res;
    }

}
