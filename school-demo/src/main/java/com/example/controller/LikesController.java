package com.example.controller;

import com.example.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likes")
public class LikesController {

    @Autowired
    private LikesService likesService;

    @PostMapping
    public void addLike(@RequestParam Integer productId, @RequestParam Integer userId) {
        System.out.println("addLike called with productId: " + productId + ", userId: " + userId);
        likesService.addLike(productId, userId);
    }

    @DeleteMapping
    public void removeLike(@RequestParam Integer productId, @RequestParam Integer userId) {
        System.out.println("removeLike called with productId: " + productId + ", userId: " + userId);
        likesService.removeLike(productId, userId);
    }

    @GetMapping("/count")
    public Integer countLikesByProductId(@RequestParam Integer productId) {
        return likesService.countLikesByProductId(productId);
    }

    @GetMapping("/check")
    public boolean checkLike(@RequestParam Integer productId, @RequestParam Integer userId) {
        System.out.println("checkLike called with productId: " + productId + ", userId: " + userId);
        return likesService.checkLike(productId, userId);
    }
}