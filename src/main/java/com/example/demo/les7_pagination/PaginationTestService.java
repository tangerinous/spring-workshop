package com.example.demo.les7_pagination;

import com.example.demo.les3_jpql.Order;
import com.example.demo.les3_jpql.OrderRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Random;

@Service
public class PaginationTestService {
    @Autowired
    OrderRepository orderRepository;

//    @PostConstruct
    public void init() {
        genOrders();
        // Параметры для пагинации: страница 0, размер страницы 10
        PageRequest pageable = PageRequest
            .of(0, 10, Sort.by("price").ascending());

        Page<Order> page = orderRepository.findAll(pageable);

        List<Order> orders = page.getContent();
        System.out.println("Total Pages: " + page.getTotalPages());
        System.out.println("Total Elements: " + page.getTotalElements());
        orders.forEach(order -> System.out.println(order.getProductName()));
    }

    public void genOrders(){
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            orderRepository.save(new Order(random.nextDouble(100), "Phone " + i));
        }
    }
}
