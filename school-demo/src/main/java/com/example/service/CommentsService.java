package com.example.service;

import com.example.entity.Comments;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

public interface CommentsService {
    List<Comments> findAll();
    Comments findById(Integer id);
    List<Comments> findByProductId(Integer productId);
    List<Comments> findByUserId(Integer userId);
    boolean insert(Comments comments);
    boolean update(Comments comments);
    boolean deleteById(Integer id);
    String uploadImage(MultipartFile file);
    boolean checkCommentExists(Integer userId, Integer productId);
} 