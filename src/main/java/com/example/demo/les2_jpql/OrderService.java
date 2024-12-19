package com.example.demo.les2_jpql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

//    @PostConstruct
    public void demo() {
        // Добавим несколько заказов
        orderRepository.save(new Order(100.0, "Phone"));
        orderRepository.save(new Order(200.0, "Laptop"));
        orderRepository.save(new Order(50.0, "Book"));

        // Запрос с null
        List<Order> allOrders = orderRepository.findByProductNameContaining(null);
        System.err.println("All orders: " + allOrders);

        List<Order> fiOrderList = orderRepository.findByProductNameSafe(null);
        System.err.println("Orders with modified" + fiOrderList);
    }
}
