package com.example.entity;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class Product {
    private Integer productId;
    private String productName;
    private String category;
    private BigDecimal price;
    private String description;
    private Integer stock;
    private String imageUrl;
} 