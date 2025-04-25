package com.example.service.impl;

import com.example.entity.Product;
import com.example.entity.ProductDetail;
import com.example.mapper.ProductMapper;
import com.example.service.ProductService;
import com.example.dto.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Override
    public List<Product> findAll() {
        return productMapper.findAll();
    }

    @Override
    public Product findById(Integer productId) {
        return productMapper.findById(productId);
    }

    @Override
    public List<Product> findByCategory(String category) {
        return productMapper.findByCategory(category);
    }

    @Override
    public boolean insert(Product product) {
        return productMapper.insert(product) > 0;
    }

    @Override
    public boolean update(Product product) {
        return productMapper.update(product) > 0;
    }

    @Override
    public boolean deleteById(Integer productId) {
        Product product = findById(productId);
        if (product != null && product.getImageUrl() != null) {
            // 删除对应的图片文件
            String imagePath = uploadDir + File.separator + new File(product.getImageUrl()).getName();
            new File(imagePath).delete();
        }
        return productMapper.deleteById(productId) > 0;
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
    public PageResult<Product> findByPage(int pageNum, int pageSize) {
        // 计算偏移量
        int offset = (pageNum - 1) * pageSize;
        
        // 查询当前页数据
        List<Product> products = productMapper.findByPage(offset, pageSize);
        
        // 查询总记录数
        int total = productMapper.count();
        
        // 返回分页结果
        return new PageResult<>(products, total, pageNum, pageSize);
    }

    @Override
    public PageResult<Product> findByCategoryAndPage(String category, int pageNum, int pageSize) {
        // 计算偏移量
        int offset = (pageNum - 1) * pageSize;
        
        // 查询当前页数据
        List<Product> products = productMapper.findByCategoryAndPage(category, offset, pageSize);
        
        // 查询总记录数
        int total = productMapper.countByCategory(category);
        
        // 返回分页结果
        return new PageResult<>(products, total, pageNum, pageSize);
    }
} 