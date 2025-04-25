package com.example.service.impl;

import com.example.dto.ProductAnalyticsDTO;
import com.example.mapper.ProductAnalyticsMapper;
import com.example.service.ProductAnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductAnalyticsServiceImpl implements ProductAnalyticsService {
    @Autowired
    private ProductAnalyticsMapper productAnalyticsMapper;

    @Override
    public List<ProductAnalyticsDTO> getTopSellingProducts(int limit) {
        return productAnalyticsMapper.findTopSellingProducts(limit);
    }

    @Override
    public ProductAnalyticsDTO getProductAnalytics(Integer productId) {
        return productAnalyticsMapper.findProductAnalytics(productId);
    }

    @Override
    public List<ProductAnalyticsDTO> getAllProductsAnalytics() {
        return productAnalyticsMapper.findAllProductsAnalytics();
    }

    @Override
    public List<ProductAnalyticsDTO> getProductAnalyticsByCategory(String category) {
        return productAnalyticsMapper.findProductAnalyticsByCategory(category);
    }

    @Override
    public List<ProductAnalyticsDTO> getProductAnalyticsByDateRange(String startDate, String endDate) {
        return productAnalyticsMapper.findProductAnalyticsByDateRange(startDate, endDate);
    }
} 