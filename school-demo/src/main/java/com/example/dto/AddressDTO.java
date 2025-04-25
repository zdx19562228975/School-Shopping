package com.example.dto;

import lombok.Data;

@Data
public class AddressDTO {
    private Integer id;
    private Integer userId;
    private String deliveryAddress;
    private String deliveryPhone;
    private String deliveryPersonName;
    
    // 额外的展示字段
    private String userName;
} 