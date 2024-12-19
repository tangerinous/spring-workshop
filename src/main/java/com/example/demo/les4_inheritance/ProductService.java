package com.example.demo.les4_inheritance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductTestRepository productTestRepository;

//    @PostConstruct
    public void init() {
        Book book = new Book("Java Basics", "John Doe");
        Toy toy = new Toy("Lego Set", 5);

        // Сохраняем в базу
        productTestRepository.save(book);
        productTestRepository.save(toy);

        // Загружаем все продукты
        List<ProductItem> productItems = productTestRepository.findAll();
        productItems.forEach(System.out::println);
    }
}
