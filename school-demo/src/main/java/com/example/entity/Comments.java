package com.example.entity;

import lombok.Data;

@Data
public class Comments {
    private Integer id;
    private String commentText;
    private Integer productId;
    private Integer userId;
    private String type;
    private Double score;
    private String image;
}
