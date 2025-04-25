package com.example.controller;

import com.example.entity.Carts;
import com.example.service.CartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartsController {
    @Autowired
    private CartsService cartsService;

    @PostMapping
    public void addCart(@RequestBody Carts cart) {
        cartsService.addCart(cart);
    }
    @DeleteMapping
    public void removeLike(@RequestParam Integer productId, @RequestParam Integer userId) {
        System.out.println("removeLike called with productId: " + productId + ", userId: " + userId);
        cartsService.removecarts(productId, userId);
    }
    @GetMapping("/{id}")
    public Carts getCartById(@PathVariable int id) {
        return cartsService.getCartById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Carts> getCartsByUserId(@PathVariable int userId) {
        return cartsService.getCartsByUserId(userId);
    }

    @PutMapping
    public void updateCart(@RequestBody Carts cart) {
        cartsService.updateCart(cart);
    }

    @DeleteMapping("/{id}")
    public void deleteCartById(@PathVariable int id) {
        cartsService.deleteCartById(id);
    }

    @GetMapping("/check")
    public boolean checkLike(@RequestParam Integer productId, @RequestParam Integer userId) {
        System.out.println("checcarts called with productId: " + productId + ", userId: " + userId);
        return cartsService.checkcarts(productId, userId);
    }
}