package com.example.service.impl;

import com.example.entity.Comments;
import com.example.mapper.CommentsMapper;
import com.example.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class CommentsServiceImpl implements CommentsService {
    @Autowired
    private CommentsMapper commentsMapper;

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Override
    public List<Comments> findAll() {
        return commentsMapper.findAll();
    }

    @Override
    public Comments findById(Integer id) {
        return commentsMapper.findById(id);
    }

    @Override
    public List<Comments> findByProductId(Integer productId) {
        return commentsMapper.findByProductId(productId);
    }

    @Override
    public List<Comments> findByUserId(Integer userId) {
        return commentsMapper.findByUserId(userId);
    }

    @Override
    public boolean insert(Comments comments) {
        return commentsMapper.insert(comments) > 0;
    }

    @Override
    public boolean update(Comments comments) {
        return commentsMapper.update(comments) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        Comments comment = findById(id);
        if (comment != null && comment.getImage() != null) {
            // 删除对应的图片文件
            String imagePath = uploadDir + File.separator + new File(comment.getImage()).getName();
            new File(imagePath).delete();
        }
        return commentsMapper.deleteById(id) > 0;
    }

    @Override
    public String uploadImage(MultipartFile file) {
        if (file.isEmpty()) {
            return null;
        }

        // 确保上传目录存在
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // 生成唯一的文件名
        String originalFilename = file.getOriginalFilename();
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String filename = UUID.randomUUID().toString() + extension;
        
        // 保存文件
        try {
            File destFile = new File(dir.getAbsolutePath() + File.separator + filename);
            file.transferTo(destFile);
            return "/images/" + filename; // 返回相对路径
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean checkCommentExists(Integer userId, Integer productId) {
        return commentsMapper.checkCommentExists(userId, productId) != null;
    }
} 