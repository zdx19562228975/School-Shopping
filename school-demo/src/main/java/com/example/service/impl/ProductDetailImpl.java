package com.example.service.impl;

import com.example.entity.ProductDetail;
import com.example.mapper.ProductDetailMapper;
import com.example.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailImpl implements ProductDetailService {

    @Autowired
    private ProductDetailMapper productDetailMapper;

    @Override
    public int updateViewCount(int productDetailId) {
        return productDetailMapper.updateViewCount(productDetailId);
    }

    @Override
    public int updateLikeCount(int productDetailId) {
        return productDetailMapper.updateLikeCount(productDetailId);
    }

    @Override
    public int updateFavoriteCount(int productDetailId) {
        return productDetailMapper.updateFavoriteCount(productDetailId);
    }

    @Override
    public ProductDetail findById(Integer productDetailId) {
        return productDetailMapper.findById(productDetailId);
    }

    @Override
    public int update(ProductDetail productDetail) {
        return productDetailMapper.update(productDetail);
    }

    @Override
    public ProductDetail insert(ProductDetail productDetail) {
        productDetailMapper.insert(productDetail);
        return productDetail;
    }

    @Override
    public List<ProductDetail> findByCategory(String category) {
        return productDetailMapper.findByCategory(category);
    }

    @Override
    public List<ProductDetail> findAll() {
        return productDetailMapper.findAll();
    }
    
    @Override
    public Integer getDetailIdByProductId(Integer productId) {
        return productDetailMapper.getDetailIdByProductId(productId);
    }
}
