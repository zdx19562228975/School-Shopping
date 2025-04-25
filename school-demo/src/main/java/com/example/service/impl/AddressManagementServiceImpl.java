package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.AddressManagement;
import com.example.mapper.AddressManagementMapper;
import com.example.service.AddressManagementService;
import com.example.dto.AddressDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressManagementServiceImpl extends ServiceImpl<AddressManagementMapper, AddressManagement> implements AddressManagementService {

    @Override
    @Transactional
    public AddressDTO addAddress(AddressDTO addressDTO) {
        AddressManagement address = new AddressManagement();
        BeanUtils.copyProperties(addressDTO, address);
        save(address);
        addressDTO.setId(address.getId());
        return addressDTO;
    }

    @Override
    @Transactional
    public boolean updateAddress(AddressDTO addressDTO) {
        if (addressDTO.getId() == null) {
            return false;
        }
        AddressManagement address = new AddressManagement();
        BeanUtils.copyProperties(addressDTO, address);
        return updateById(address);
    }

    @Override
    @Transactional
    public boolean deleteAddress(Integer addressId) {
        return removeById(addressId);
    }

    @Override
    public List<AddressDTO> getUserAddresses(Integer userId) {
        LambdaQueryWrapper<AddressManagement> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(AddressManagement::getUserId, userId);
        
        return list(wrapper).stream()
            .map(address -> {
                AddressDTO dto = new AddressDTO();
                BeanUtils.copyProperties(address, dto);
                // TODO: 获取用户信息
                return dto;
            })
            .collect(Collectors.toList());
    }

    @Override
    public AddressDTO getAddressDetail(Integer addressId) {
        AddressManagement address = getById(addressId);
        if (address == null) {
            return null;
        }
        AddressDTO addressDTO = new AddressDTO();
        BeanUtils.copyProperties(address, addressDTO);
        // TODO: 获取用户信息
        return addressDTO;
    }
} 