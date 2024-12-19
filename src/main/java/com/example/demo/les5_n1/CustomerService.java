package com.example.demo.les5_n1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

//    @PostConstruct
    public void postConstruct() {
        Random random = new Random();
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Customer customer = new Customer("John Doe");
            for (int j = 0; j < random.nextInt(4); j++) {
                customer.addOrder(new OrderEntity(random.nextDouble(100)));
            }
            customers.add(customer);
        }
        customerRepository.saveAll(customers);

        List<Customer> list = customerRepository.findAll();
        for (Customer customer : list) {
            System.err.println("Customer: " + customer.getName());
            for (OrderEntity order : customer.getOrders()) {
                System.err.println("Order price: " + order.getPrice());
            }
        }
    }
}
