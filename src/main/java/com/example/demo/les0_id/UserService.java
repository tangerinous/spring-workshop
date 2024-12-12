package com.example.demo.les0_id;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init() {
//        User user = new User();
//        user.setName("Hibernate Inserted User");
//        userRepository.save(user);
    }
}
