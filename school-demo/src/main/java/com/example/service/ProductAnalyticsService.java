package com.example.service;

import com.example.dto.ProductAnalyticsDTO;
import java.util.List;

public interface ProductAnalyticsService {
    // 获取销量最高的N个商品
    List<ProductAnalyticsDTO> getTopSellingProducts(int limit);
    
    // 获取指定商品的销售数据
    ProductAnalyticsDTO getProductAnalytics(Integer productId);
    
    // 获取所有商品的销售数据
    List<ProductAnalyticsDTO> getAllProductsAnalytics();
    
    // 获取指定类别的商品销售数据
    List<ProductAnalyticsDTO> getProductAnalyticsByCategory(String category);
    
    // 获取指定时间范围内的商品销售数据
    List<ProductAnalyticsDTO> getProductAnalyticsByDateRange(String startDate, String endDate);
} 