package com.example.mapper;

import com.example.entity.ProductDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductDetailMapper {
    int updateViewCount(int productDetailId);
    int updateLikeCount(int productDetailId);
    int updateFavoriteCount(int productDetailId);
    ProductDetail findById(Integer productDetailId);
    int update(ProductDetail productDetail);
    int insert(ProductDetail productDetail);
    List<ProductDetail> findByCategory(String category);
    List<ProductDetail> findAll();
    
    // 根据商品ID获取商品详情ID
    Integer getDetailIdByProductId(@Param("productId") Integer productId);
}
