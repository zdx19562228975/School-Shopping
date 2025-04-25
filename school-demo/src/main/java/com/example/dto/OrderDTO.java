package com.example.dto;

import lombok.Data;
import java.time.LocalDateTime;
import java.math.BigDecimal;

@Data
public class OrderDTO {
    private Integer id;
    private Integer productId;
    private String logisticsStatus;
    private LocalDateTime createdAt;
    private Integer number;
    private BigDecimal singlePrice;
    private BigDecimal totalPrice;
    private Integer addressId;
    
    // 额外的展示字段
    private String productName;
    private String productImage;
    private String deliveryAddress;
    private String deliveryPhone;
    private String deliveryPersonName;
} 