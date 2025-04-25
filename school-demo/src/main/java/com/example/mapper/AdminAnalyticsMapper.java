package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface AdminAnalyticsMapper {
    /**
     * 获取指定日期范围内的每日订单数
     */
    List<Map<String, Object>> getOrderCountsByDateRange(Date startDate, Date endDate);

    /**
     * 获取指定日期范围内的每日营收
     */
    List<Map<String, Object>> getRevenueByDateRange(Date startDate, Date endDate);

    /**
     * 获取商品总数和在售商品数
     */
    Map<String, Object> getProductStats();

    /**
     * 获取用户总数和活跃用户数
     */
    Map<String, Object> getUserStats();

    /**
     * 获取平均订单金额
     */
    BigDecimal getAverageOrderAmount();

    /**
     * 获取分类销量统计
     */
    List<Map<String, Object>> getCategorySales();

    /**
     * 获取订单状态统计
     */
    List<Map<String, Object>> getOrderStatusStats();

    /**
     * 获取指定日期范围内的订单状态统计
     */
    List<Map<String, Object>> getOrderStatusStatsByDateRange(Date startDate, Date endDate);

    /**
     * 获取今日和昨日的订单总数和总收入
     */
    Map<String, Object> getDailyComparison();

    /**
     * 获取今日和昨日的商品总数
     */
    Map<String, Object> getProductComparison();

    /**
     * 获取今日和昨日的用户总数
     */
    Map<String, Object> getUserComparison();

    /**
     * 获取用户增长趋势
     */
    List<Map<String, Object>> getUserGrowthTrend();
} 