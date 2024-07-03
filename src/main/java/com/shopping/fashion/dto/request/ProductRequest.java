package com.shopping.fashion.dto.request;
import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private double price;
    private int discount;
    private String description;
    private String image;
    private int quantity;
    private int categoryId;
}
