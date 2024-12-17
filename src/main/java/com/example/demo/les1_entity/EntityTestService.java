package com.example.demo.les1_entity;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntityTestService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

//    @PostConstruct
    public void init() {
        Category category = new Category();
        category.setId(1l);
        category.setName("Electronics");
        category = categoryRepository.save(category); // TODO 1

        Product product = new Product();
        product.setId(1l);
        product.setProductName("Smartphone");
        product.setCategory(category);
        product = productRepository.save(product);

//        Category c = categoryRepository.findById(1l).get();
//        categoryRepository.delete(c); // todo 2

//        Product p = productRepository.findById(1l).get();
//        productRepository.delete(p); // todo 3

    }

    private void test() {

    }
}
