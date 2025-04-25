package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.time.LocalDateTime;
import java.math.BigDecimal;

@Data
@TableName("orders")
public class Orders {
    @TableId(type = IdType.AUTO)
    private Integer id;
    
    private Integer productId;
    
    private String logisticsStatus;
    
    private LocalDateTime createdAt;
    
    private Integer number;
    
    private BigDecimal singlePrice;
    
    private BigDecimal totalPrice;
    
    private Integer addressId;
} 