package com.example.springstudy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springstudy.entities.User;

@Repository
public interface UserRespository extends JpaRepository<User, Long>{
 
}
