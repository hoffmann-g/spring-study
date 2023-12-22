package com.example.springstudy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.springstudy.entities.User;
import com.example.springstudy.repositories.UserRespository;

@Configuration
@Profile("test") // runs only in test profile
public class TestConfig implements CommandLineRunner{
    
    @Autowired
    private UserRespository userRespository; // extends JpaRepository

    @Override
    public void run(String... args) throws Exception {
        
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "11 2 3333 4444", "password");
        User u2 = new User(null, "Bobby Junior", "bobbyjr@gmail.com", "11 2 3333 4444", "password");

        userRespository.save(u1);
        userRespository.save(u2);
    }

}
