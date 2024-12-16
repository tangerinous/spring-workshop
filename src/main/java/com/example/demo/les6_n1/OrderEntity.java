package com.example.demo.les6_n1;

import jakarta.persistence.*;

@Entity
@Table(name = "customer_orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double price;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public OrderEntity() {}
    public OrderEntity(Double price) { this.price = price; }

    public Long getId() { return id; }
    public Double getPrice() { return price; }
    public Customer getCustomer() { return customer; }

    public void setPrice(Double price) { this.price = price; }
    public void setCustomer(Customer customer) { this.customer = customer; }
}
