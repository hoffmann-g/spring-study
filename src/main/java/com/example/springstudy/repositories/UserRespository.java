package com.example.springstudy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springstudy.entities.User;

public interface UserRespository extends JpaRepository<User, Long>{
 
}
