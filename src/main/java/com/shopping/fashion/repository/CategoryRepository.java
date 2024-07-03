package com.shopping.fashion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.fashion.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
