package com.example.service;

public interface LikesService {
    void addLike(Integer productId, Integer userId);
    void removeLike(Integer productId, Integer userId);
    Integer countLikesByProductId(Integer productId);
    boolean checkLike(Integer productId, Integer userId);
}