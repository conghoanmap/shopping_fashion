package com.shopping.fashion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.fashion.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/")
    public ResponseEntity<?> welcome() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

}
