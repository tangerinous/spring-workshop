package com.example.demo.les4_batch;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Item() {}
    public Item(String name) { this.name = name; }
}



//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq")
//    @SequenceGenerator(name = "item_seq", sequenceName = "item_seq", allocationSize = 50)