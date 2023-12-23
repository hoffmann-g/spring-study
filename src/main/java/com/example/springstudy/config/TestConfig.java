package com.example.springstudy.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.springstudy.entities.Category;
import com.example.springstudy.entities.Order;
import com.example.springstudy.entities.Product;
import com.example.springstudy.entities.User;
import com.example.springstudy.entities.enums.OrderStatus;
import com.example.springstudy.repositories.CategoryRepository;
import com.example.springstudy.repositories.OrderRepository;
import com.example.springstudy.repositories.ProductRepository;
import com.example.springstudy.repositories.UserRespository;

@Configuration
@Profile("test") // runs only in test profile
public class TestConfig implements CommandLineRunner{
    
    @Autowired
    private UserRespository userRespository; // extends JpaRepository
    
    @Autowired
    private OrderRepository orderRepository; // extends JpaRepository

    @Autowired
    private CategoryRepository categoryRepository; // extends JpaRepository

    @Autowired
    private ProductRepository productRepository; // extends JpaRepository

    @Override
    public void run(String... args) throws Exception {

        Category c1 = new Category(null, "Electronics");
        Category c2 = new Category(null, "Books");
        Category c3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.getCategories().add(c1);

        p2.getCategories().add(c1);
        p2.getCategories().add(c3);

        p3.getCategories().add(c3);

        p4.getCategories().add(c3);

        p5.getCategories().add(c2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
        
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "11 2 3333 4444", "password");
        User u2 = new User(null, "Bobby Junior", "bobbyjr@gmail.com", "11 2 3333 4444", "password");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        userRespository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        
    }

}
