package com.example.mapper;

import com.example.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductMapper {
    List<Product> findAll();
    Product findById(Integer productId);
    List<Product> findByCategory(String category);
    int insert(Product product);
    int update(Product product);
    int deleteById(Integer productId);
    
    // 添加分页查询方法
    List<Product> findByPage(@Param("offset") int offset, @Param("pageSize") int pageSize);
    
    // 获取总记录数
    int count();
    
    // 按类别分页查询
    List<Product> findByCategoryAndPage(
        @Param("category") String category, 
        @Param("offset") int offset, 
        @Param("pageSize") int pageSize
    );
    
    // 获取指定类别的总记录数
    int countByCategory(@Param("category") String category);
} 