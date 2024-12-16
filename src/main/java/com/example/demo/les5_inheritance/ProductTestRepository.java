package com.example.demo.les5_inheritance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTestRepository extends JpaRepository<ProductItem, Long> {
}
