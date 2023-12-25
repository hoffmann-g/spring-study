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

    public User insert(User user){
        return userRespository.save(user);
    }

    public void delete(Long id){
        userRespository.deleteById(id);
    }

    public User update(Long id, User user){
        User entity = userRespository.getReferenceById(id);
        updateData(entity, user);
        return userRespository.save(entity);
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }
}
