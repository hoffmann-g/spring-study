package com.example.springstudy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.springstudy.entities.User;
import com.example.springstudy.repositories.UserRespository;
import com.example.springstudy.services.exceptions.DatabaseException;
import com.example.springstudy.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRespository userRespository;

    public List<User> findAll(){
        return userRespository.findAll();
    }

    public User findById(Long id){
        return userRespository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user){
        return userRespository.save(user);
    }

    public void delete(Long id){   
        try { 
            userRespository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(id);
        }
    }

    public User update(Long id, User user){
        try {
            User entity = userRespository.getReferenceById(id);
            updateData(entity, user);
            return userRespository.save(entity);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }
}
