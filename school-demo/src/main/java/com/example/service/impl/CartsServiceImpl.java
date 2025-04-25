package com.example.service.impl;

import com.example.entity.Carts;
import com.example.mapper.CartsMapper;
import com.example.service.CartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartsServiceImpl implements CartsService {
    @Autowired
    private CartsMapper cartsMapper;

    @Override
    public void addCart(Carts cart) {
        cartsMapper.insert(cart);
    }

    @Override
    public Carts getCartById(int id) {
        return cartsMapper.findById(id);
    }

    @Override
    public List<Carts> getCartsByUserId(int userId) {
        return cartsMapper.findByUserId(userId);
    }

    @Override
    public void updateCart(Carts cart) {
        cartsMapper.update(cart);
    }

    @Override
    public void deleteCartById(int id) {
        cartsMapper.deleteById(id);
    }

    @Override
    public boolean checkcarts(Integer productId, Integer userId) {
        return cartsMapper.checkcarts(productId, userId) > 0;
    }

    @Override
    public void removecarts(Integer productId, Integer userId) {
        cartsMapper.removecarts(productId, userId);
    }
}