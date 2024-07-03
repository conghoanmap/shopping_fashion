package com.shopping.fashion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.fashion.dto.request.ProductRequest;
import com.shopping.fashion.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public ResponseEntity<?> welcome() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/getProductById/{id}")
    public ResponseEntity<?> getProductById(@PathVariable int id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping("/addProduct")
    public ResponseEntity<?> addProduct(@RequestBody ProductRequest req) {
        productService.addProduct(req);
        return ResponseEntity.ok("Product added successfully");
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable int id, @RequestBody ProductRequest req) {
        productService.updateProduct(id, req);
        return ResponseEntity.ok("Product updated successfully");
    }

    @GetMapping("/calculateInventoryValue")
    public ResponseEntity<?> calculateInventoryValue() {
        return ResponseEntity.ok(productService.calculateInventoryValue());
    }

}
