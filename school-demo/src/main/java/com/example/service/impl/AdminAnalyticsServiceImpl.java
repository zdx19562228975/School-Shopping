package com.example.service.impl;

import com.example.dto.AdminAnalyticsDTO;
import com.example.mapper.AdminAnalyticsMapper;
import com.example.service.AdminAnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class AdminAnalyticsServiceImpl implements AdminAnalyticsService {

    @Autowired
    private AdminAnalyticsMapper adminAnalyticsMapper;

    @Override
    public AdminAnalyticsDTO getLastSevenDaysAnalytics() {
        // 计算过去7天的日期范围
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(6);
        
        Date start = Date.from(startDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date end = Date.from(endDate.plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        AdminAnalyticsDTO dto = getAnalyticsByDateRange(start, end);
        
        // 获取今日和昨日的比较数据
        Map<String, Object> dailyComparison = adminAnalyticsMapper.getDailyComparison();
        Map<String, Object> productComparison = adminAnalyticsMapper.getProductComparison();
        Map<String, Object> userComparison = adminAnalyticsMapper.getUserComparison();
        
        // 设置订单和收入比较数据
        dto.setTotalOrders(((Number) dailyComparison.get("today_orders")).intValue());
        dto.setPreviousTotalOrders(((Number) dailyComparison.get("yesterday_orders")).intValue());
        dto.setTotalRevenue((BigDecimal) dailyComparison.get("today_revenue"));
        dto.setPreviousTotalRevenue((BigDecimal) dailyComparison.get("yesterday_revenue"));
        
        // 设置商品比较数据
        dto.setTotalProducts(((Number) productComparison.get("total_products")).intValue());
        dto.setActiveProducts(((Number) productComparison.get("active_products")).intValue());
        
        // 设置用户比较数据
        dto.setTotalUsers(((Number) userComparison.get("total_users")).intValue());
        dto.setPreviousTotalUsers(((Number) userComparison.get("yesterday_total_users")).intValue());
        dto.setActiveUsers(((Number) userComparison.get("active_users")).intValue());
        
        // 获取用户增长趋势
        List<Map<String, Object>> userGrowthTrend = adminAnalyticsMapper.getUserGrowthTrend();
        List<String> growthDates = new ArrayList<>();
        List<Integer> growthCounts = new ArrayList<>();
        
        userGrowthTrend.forEach(map -> {
            growthDates.add(map.get("growth_date").toString());
            growthCounts.add(((Number) map.get("new_users")).intValue());
        });
        
        dto.setUserGrowthDates(growthDates);
        dto.setUserGrowthCounts(growthCounts);
        
        // 获取订单状态统计
        List<Map<String, Object>> orderStatusStats = adminAnalyticsMapper.getOrderStatusStats();
        for (Map<String, Object> stat : orderStatusStats) {
            String status = (String) stat.get("logistics_status");
            Integer count = ((Number) stat.get("count")).intValue();
            
            switch (status) {
                case "PENDING_PAYMENT":
                    dto.setPendingPaymentOrders(count);
                    break;
                case "PENDING_SHIPMENT":
                    dto.setPendingShipmentOrders(count);
                    break;
                case "SHIPPED":
                    dto.setShippedOrders(count);
                    break;
                case "COMPLETED":
                    dto.setCompletedOrders(count);
                    break;
                case "CANCELLED":
                    dto.setCancelledOrders(count);
                    break;
                case "REFUND_PENDING":
                    dto.setRefundPendingOrders(count);
                    break;
                case "REFUNDED":
                    dto.setRefundedOrders(count);
                    break;
            }
        }
        
        return dto;
    }

    @Override
    public AdminAnalyticsDTO getAnalyticsByDateRange(Date startDate, Date endDate) {
        AdminAnalyticsDTO dto = new AdminAnalyticsDTO();
        
        // 获取订单数据
        List<Map<String, Object>> orderCounts = adminAnalyticsMapper.getOrderCountsByDateRange(startDate, endDate);
        List<Map<String, Object>> revenues = adminAnalyticsMapper.getRevenueByDateRange(startDate, endDate);
        
        // 设置订单数据
        List<String> orderDates = new ArrayList<>();
        List<Integer> orderCountList = new ArrayList<>();
        List<String> revenueDates = new ArrayList<>();
        List<BigDecimal> revenueAmounts = new ArrayList<>();
        
        orderCounts.forEach(map -> {
            orderDates.add(map.get("order_date").toString());
            orderCountList.add(((Number) map.get("order_count")).intValue());
        });
        
        revenues.forEach(map -> {
            revenueDates.add(map.get("revenue_date").toString());
            revenueAmounts.add((BigDecimal) map.get("daily_revenue"));
        });
        
        dto.setOrderDates(orderDates);
        dto.setOrderCounts(orderCountList);
        dto.setRevenueDates(revenueDates);
        dto.setRevenueAmounts(revenueAmounts);
        
        // 设置平均订单金额
        dto.setAverageOrderAmount(adminAnalyticsMapper.getAverageOrderAmount());
        
        return dto;
    }

    @Override
    public AdminAnalyticsDTO getProductAnalytics() {
        AdminAnalyticsDTO dto = new AdminAnalyticsDTO();
        Map<String, Object> productStats = adminAnalyticsMapper.getProductStats();
        
        dto.setTotalProducts(((Number) productStats.get("total_products")).intValue());
        dto.setActiveProducts(((Number) productStats.get("active_products")).intValue());
        
        return dto;
    }

    @Override
    public AdminAnalyticsDTO getUserAnalytics() {
        AdminAnalyticsDTO dto = new AdminAnalyticsDTO();
        Map<String, Object> userStats = adminAnalyticsMapper.getUserStats();
        
        dto.setTotalUsers(((Number) userStats.get("total_users")).intValue());
        dto.setActiveUsers(((Number) userStats.get("active_users")).intValue());
        
        return dto;
    }

    @Override
    public AdminAnalyticsDTO getCategoryAnalytics() {
        AdminAnalyticsDTO dto = new AdminAnalyticsDTO();
        List<Map<String, Object>> categorySales = adminAnalyticsMapper.getCategorySales();
        
        List<String> categories = new ArrayList<>();
        List<Integer> salesCounts = new ArrayList<>();
        
        categorySales.forEach(map -> {
            categories.add((String) map.get("category"));
            salesCounts.add(((Number) map.get("sales_count")).intValue());
        });
        
        dto.setCategories(categories);
        dto.setCategorySales(salesCounts);
        
        return dto;
    }

    @Override
    public List<Map<String, Object>> getOrderStatusStats() {
        return adminAnalyticsMapper.getOrderStatusStats();
    }

    @Override
    public List<Map<String, Object>> getOrderStatusStatsByDateRange(Date startDate, Date endDate) {
        return adminAnalyticsMapper.getOrderStatusStatsByDateRange(startDate, endDate);
    }
} 