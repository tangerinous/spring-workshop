package com.example.demo.les6_n1;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c JOIN FETCH c.orders")
    List<Customer> findAllWithOrders();

    @EntityGraph(attributePaths = {"orders"})
    @Query("SELECT c FROM Customer c")
    List<Customer> findAllWithOrdersUsingGraph();
}
