package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("address_management")
public class AddressManagement {
    @TableId(type = IdType.AUTO)
    private Integer id;
    
    private Integer userId;
    
    private String deliveryAddress;
    
    private String deliveryPhone;
    
    private String deliveryPersonName;
} 