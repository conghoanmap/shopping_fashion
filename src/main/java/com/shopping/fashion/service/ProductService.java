package com.shopping.fashion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.fashion.dto.request.ProductRequest;
import com.shopping.fashion.model.Category;
import com.shopping.fashion.model.Product;
import com.shopping.fashion.repository.CategoryRepository;
import com.shopping.fashion.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Transactional
    public void addProduct(ProductRequest product) {
        productRepository.add_product(product.getName(), product.getDescription(), product.getImage(), product.getPrice(),
                product.getDiscount(), product.getQuantity(), product.getCategoryId());

        // Product newProduct = new Product();
        // newProduct.setName(product.getName());
        // newProduct.setDescription(product.getDescription());
        // newProduct.setImage(product.getImage());
        // newProduct.setPrice(product.getPrice());
        // newProduct.setDiscount(product.getDiscount());
        // newProduct.setQuantity(product.getQuantity());
        // Category category = new Category();
        // category = categoryRepository.findById(product.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found"));
        // newProduct.setCategory(category);
        // productRepository.save(newProduct);
    }

    @Transactional
    public void deleteProduct(int id) {
        productRepository.delete_product(id);

        // Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        // productRepository.delete(product);
    }

    @Transactional
    public void updateProduct(int id, ProductRequest product) {
        productRepository.update_product( id, product.getName(), product.getDescription(), product.getImage(),
                product.getPrice(), product.getDiscount(), product.getQuantity(), product.getCategoryId());

        // Product updatedProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        // updatedProduct.setName(product.getName());
        // updatedProduct.setDescription(product.getDescription());
        // updatedProduct.setImage(product.getImage());
        // updatedProduct.setPrice(product.getPrice());
        // updatedProduct.setDiscount(product.getDiscount());
        // updatedProduct.setQuantity(product.getQuantity());
        // Category category = new Category();
        // category = categoryRepository.findById(product.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found"));
        // updatedProduct.setCategory(category);
        // productRepository.save(updatedProduct);
    }

    public double calculateInventoryValue() {
        return productRepository.calculate_inventory_value();
    }

}
