package com.example.service;

import com.example.entity.ProductDetail;

import java.util.List;

public interface ProductDetailService {
    int updateViewCount(int productDetailId);
    int updateLikeCount(int productDetailId);
    int updateFavoriteCount(int productDetailId);
    ProductDetail findById(Integer productDetailId);
    int update(ProductDetail productDetail);
    ProductDetail insert(ProductDetail productDetail);
    List<ProductDetail> findByCategory(String category);
    List<ProductDetail> findAll();
    
    // 根据商品ID获取商品详情ID
    Integer getDetailIdByProductId(Integer productId);
}
