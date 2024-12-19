package com.example.demo.les8_locks;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LockOrderService {

    @Autowired
    private OrderItemRepository orderRepository;

    @Transactional
    public void add10toPrice(double v) {
        try {
            OrderItem order = orderRepository.findById(1L).orElseThrow();
            System.err.println(Thread.currentThread() + " loaded price and version: " + order.getPrice() + " " + order.getVersion());
            Thread.sleep(5000);
            order.setPrice(order.getPrice() + v);
            orderRepository.save(order); // Версия увеличивается
            System.err.println(Thread.currentThread() + " updated price and version: " + order.getPrice() + " " + order.getVersion());
        } catch (Exception e) {
            System.err.println(Thread.currentThread() + "OptimisticLockException: Conflict detected!");
        }
    }

    public void ping() {
        System.err.println("Pong");
    }
}
