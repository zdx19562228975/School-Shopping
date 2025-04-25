package com.example.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDetail {
    private Integer Id;
    private Integer productId;
    private String productName;
    private String category;
    private BigDecimal price;
    private String description;
    private Integer stock;
    private String imageUrl;
    private Integer favoriteCount;
    private Integer likeCount;
    private Integer commentCount;
    private Integer purchaseCount;
    private Integer viewCount;
}
