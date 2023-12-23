package com.example.springstudy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springstudy.entities.User;
import com.example.springstudy.repositories.UserRespository;

@Service
public class UserService {

    @Autowired
    private UserRespository userRespository;

    public List<User> findAll(){
        return userRespository.findAll();
    }

    public User findById(Long id){
        return userRespository.findById(id).get();
    }
}