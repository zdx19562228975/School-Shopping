package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.AddressManagement;
import com.example.dto.AddressDTO;
import java.util.List;

public interface AddressManagementService extends IService<AddressManagement> {
    // 添加收货地址
    AddressDTO addAddress(AddressDTO addressDTO);
    
    // 更新收货地址
    boolean updateAddress(AddressDTO addressDTO);
    
    // 删除收货地址
    boolean deleteAddress(Integer addressId);
    
    // 获取用户的所有收货地址
    List<AddressDTO> getUserAddresses(Integer userId);
    
    // 获取收货地址详情
    AddressDTO getAddressDetail(Integer addressId);
} 