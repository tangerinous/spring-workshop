package com.example.demo.les3_jpql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    // Исходный запрос, который не учитывает null:
     @Query("SELECT o FROM Order o WHERE o.price > :price")
     List<Order> findOrdersWithPriceGreaterThan(@Param("price") Double price);

    // Модифицированный запрос, учитывающий null:
//    @Query("SELECT o FROM Order o WHERE (:price IS NULL OR o.price > :price)")
//    List<Order> findOrdersWithPriceOptional(@Param("price") Double price);
}