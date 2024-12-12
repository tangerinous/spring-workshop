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
    @PostConstruct
    public void init() {
//        Category category = new Category();
//        category.setId(1l);
//        category.setName("Electronics");
//        category = categoryRepository.save(category);
//
//        Product product = new Product();
//        product.setId(1l);
//        product.setProductName("Smartphone");
//        product.setCategory(category);
//        product = productRepository.save(product);

        case1NullRef();
//        case2NewRef();
    }

    private void case2NewRef() {

        Category newCategory = new Category();
        newCategory.setId(2l);
        newCategory.setName("Gadgets");
        newCategory = categoryRepository.save(newCategory);

        Product product = new Product(1l, "Smartphone", newCategory);

        product = productRepository.save(product);
    }

    private void case1NullRef() {
        Product product = new Product(1l, "Smartphone", null);
        product = productRepository.save(product);

        // Нет каскадных удалений, нет сложных последствий. Просто при изменении связи в
        // коде Hibernate сделает UPDATE products SET category_id = null/новый_id WHERE id = ....
    }

    private void clear() {
        productRepository.deleteAll();
        categoryRepository.deleteAll();
    }
}
