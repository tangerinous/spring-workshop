package com.example.demo.les8_locks;

import jakarta.annotation.PostConstruct;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@EnableScheduling
@Service
public class TestingService {
    @Autowired
    private LockOrderService lockOrderService;

    @SneakyThrows
//    @Scheduled(fixedDelay = 150000)
    public void init() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        OrderItem phone = new OrderItem("Phone", 100.0);
        Future<?> submit = executorService.submit(() -> lockOrderService.add10toPrice(5.0));
        Future<?> submit1 = executorService.submit(() -> lockOrderService.add10toPrice(10.0));
        submit1.get();
        submit.get();
    }
}
