package com.example.demo.les8_locks;


import jakarta.persistence.*;

@Entity
@Table(name = "orderitems")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;

    private Double price;

    @Version // Поле версии для оптимистической блокировки
    private Long version;

    public OrderItem() {}

    public OrderItem(String productName, Double price) {
        this.productName = productName;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    // Getters и Setters
    public Long getVersion() { return version; }
    public void setVersion(Long version) { this.version = version; }
}

