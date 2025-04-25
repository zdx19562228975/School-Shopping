package com.example.mapper;

import com.example.dto.ProductAnalyticsDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductAnalyticsMapper {
    List<ProductAnalyticsDTO> findTopSellingProducts(@Param("limit") int limit);
    ProductAnalyticsDTO findProductAnalytics(@Param("productId") Integer productId);
    List<ProductAnalyticsDTO> findAllProductsAnalytics();
    List<ProductAnalyticsDTO> findProductAnalyticsByCategory(@Param("category") String category);
    List<ProductAnalyticsDTO> findProductAnalyticsByDateRange(
        @Param("startDate") String startDate,
        @Param("endDate") String endDate
    );
} 