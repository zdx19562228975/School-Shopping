package com.example.service;

import com.example.dto.PageResult;
import com.example.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Integer productId);
    List<Product> findByCategory(String category);
    boolean insert(Product product);
    boolean update(Product product);
    boolean deleteById(Integer productId);
    
    // 处理图片上传
    String uploadImage(MultipartFile file);
    
    // 添加分页方法
    PageResult<Product> findByPage(int pageNum, int pageSize);
    
    // 按类别分页查询
    PageResult<Product> findByCategoryAndPage(String category, int pageNum, int pageSize);
} 