package com.example.service;

import com.example.entity.Carts;

import java.util.List;

public interface CartsService {
    void addCart(Carts cart);
    Carts getCartById(int id);
    List<Carts> getCartsByUserId(int userId);
    void updateCart(Carts cart);
    void deleteCartById(int id);
    boolean checkcarts(Integer productId, Integer userId);

    void removecarts(Integer productId, Integer userId);

}