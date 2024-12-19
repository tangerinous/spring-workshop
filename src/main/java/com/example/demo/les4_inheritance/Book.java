package com.example.demo.les4_inheritance;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("BOOK")
public class Book extends ProductItem {

    private String author;

    public Book() {}

    public Book(String name, String author) {
        super(name);
        this.author = author;
    }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
}

