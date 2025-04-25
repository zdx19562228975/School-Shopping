package com.example.service;

import com.example.dto.AdminAnalyticsDTO;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface AdminAnalyticsService {
    /**
     * 获取过去7天的数据分析
     */
    AdminAnalyticsDTO getLastSevenDaysAnalytics();

    /**
     * 获取指定日期范围的数据分析
     */
    AdminAnalyticsDTO getAnalyticsByDateRange(Date startDate, Date endDate);

    /**
     * 获取商品相关统计数据
     */
    AdminAnalyticsDTO getProductAnalytics();

    /**
     * 获取用户相关统计数据
     */
    AdminAnalyticsDTO getUserAnalytics();

    /**
     * 获取分类销售统计数据
     */
    AdminAnalyticsDTO getCategoryAnalytics();

    /**
     * 获取订单状态统计
     */
    List<Map<String, Object>> getOrderStatusStats();

    /**
     * 获取指定日期范围内的订单状态统计
     */
    List<Map<String, Object>> getOrderStatusStatsByDateRange(Date startDate, Date endDate);
} 