package com.example.demo.les3_jpql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {


    // Вариант 1
    List<Order> findByProductNameContaining(String productName);

    // Эквивалент варианта 1 с использованием JPQL
    @Query("SELECT o FROM Order o WHERE o.productName LIKE %:keyword%")
    List<Order> findByProductNameContaining1(@Param("keyword") String keyword);









    @Query("SELECT o FROM Order o WHERE :keyword IS NULL OR o.productName LIKE %:keyword%")
    List<Order> findByProductNameSafe(@Param("keyword") String keyword);
}