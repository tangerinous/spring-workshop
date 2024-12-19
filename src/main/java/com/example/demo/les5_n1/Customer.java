package com.example.demo.les5_n1;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    private List<OrderEntity> orders = new ArrayList<>();

    public Customer() {}
    public Customer(String name) { this.name = name; }

    public Long getId() { return id; }
    public String getName() { return name; }
    public List<OrderEntity> getOrders() { return orders; }

    public void addOrder(OrderEntity order) {
        order.setCustomer(this);
        orders.add(order);
    }
}