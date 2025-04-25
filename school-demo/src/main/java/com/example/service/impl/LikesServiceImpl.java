package com.example.service.impl;

import com.example.entity.Likes;
import com.example.mapper.LikesMapper;
import com.example.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LikesServiceImpl implements LikesService {

    @Autowired
    private LikesMapper likesMapper;

    @Override
    public void addLike(Integer productId, Integer userId) {
        Likes like = new Likes();
        like.setProductId(productId);
        like.setUserId(userId);
        like.setCreatedAt(new Date());
        likesMapper.addLike(like);
    }

    @Override
    public void removeLike(Integer productId, Integer userId) {
        likesMapper.removeLike(productId, userId);
    }

    @Override
    public Integer countLikesByProductId(Integer productId) {
        return likesMapper.countLikesByProductId(productId);
    }

    @Override
    public boolean checkLike(Integer productId, Integer userId) {
        return likesMapper.checkLike(productId, userId) > 0;
    }
}