package com.example.springstudy.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.springstudy.entities.Order;
import com.example.springstudy.entities.User;
import com.example.springstudy.entities.enums.OrderStatus;
import com.example.springstudy.repositories.OrderRepository;
import com.example.springstudy.repositories.UserRespository;

@Configuration
@Profile("test") // runs only in test profile
public class TestConfig implements CommandLineRunner{
    
    @Autowired
    private UserRespository userRespository; // extends JpaRepository
    
    @Autowired
    private OrderRepository orderRepository; // extends JpaRepository

    @Override
    public void run(String... args) throws Exception {
        
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "11 2 3333 4444", "password");
        User u2 = new User(null, "Bobby Junior", "bobbyjr@gmail.com", "11 2 3333 4444", "password");

        userRespository.saveAll(Arrays.asList(u1, u2));

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

    }

}
