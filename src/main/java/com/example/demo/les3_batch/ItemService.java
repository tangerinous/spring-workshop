package com.example.demo.les3_batch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

//    @PostConstruct
    public void init(){
        List<Item> items = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            Item item = new Item("Item " + i);
            items.add(item);
        }
        long start = System.currentTimeMillis();
        itemRepository.saveAll(items);
        System.out.println("Time: " + (System.currentTimeMillis() - start));
    }

    @Autowired
    private ItemRepository2 itemRepository2;
//    @PostConstruct
    public void init2(){
        List<Item2> items = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            Item2 item = new Item2("Item " + i);
            items.add(item);
        }
        long start = System.currentTimeMillis();
        itemRepository2.saveAll(items);
        System.out.println("Time: " + (System.currentTimeMillis() - start));
    }
}
