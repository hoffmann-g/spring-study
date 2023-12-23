package com.example.springstudy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springstudy.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
 
}
