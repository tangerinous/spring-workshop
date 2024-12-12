package com.example.demo.les3_jpql;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrdersByPrice(Double price) {
        // Если price == null, вернутся все записи
        // Если price != null, вернутся записи, у которых o.price > price
        return orderRepository.findOrdersWithPriceOptional(price);
    }

    @PostConstruct
    public void demo() {
        // Добавим несколько заказов
        orderRepository.save(new Order(100.0, "Phone"));
        orderRepository.save(new Order(200.0, "Laptop"));
        orderRepository.save(new Order(50.0, "Book"));

        // Запрос с null
        List<Order> allOrders = getOrdersByPrice(null);
        System.out.println("All orders: " + allOrders);

        // Запрос с конкретным значением
        List<Order> expensiveOrders = getOrdersByPrice(100.0);
        System.out.println("Orders with price > 100.0: " + expensiveOrders);
    }
}
