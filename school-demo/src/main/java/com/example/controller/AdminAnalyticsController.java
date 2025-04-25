package com.example.controller;

import com.example.dto.AdminAnalyticsDTO;
import com.example.service.AdminAnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/analytics")
public class AdminAnalyticsController {

    @Autowired
    private AdminAnalyticsService adminAnalyticsService;

    /**
     * 获取过去7天的数据分析概览
     */
    @GetMapping("/dashboard")
    public ResponseEntity<AdminAnalyticsDTO> getDashboardAnalytics() {
        AdminAnalyticsDTO analytics = adminAnalyticsService.getLastSevenDaysAnalytics();
        return ResponseEntity.ok(analytics);
    }

    /**
     * 获取指定日期范围的数据分析
     */
    @GetMapping("/custom")
    public ResponseEntity<AdminAnalyticsDTO> getCustomRangeAnalytics(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        AdminAnalyticsDTO analytics = adminAnalyticsService.getAnalyticsByDateRange(startDate, endDate);
        return ResponseEntity.ok(analytics);
    }

    /**
     * 获取商品统计数据
     */
    @GetMapping("/products")
    public ResponseEntity<AdminAnalyticsDTO> getProductStats() {
        AdminAnalyticsDTO analytics = adminAnalyticsService.getProductAnalytics();
        return ResponseEntity.ok(analytics);
    }

    /**
     * 获取用户统计数据
     */
    @GetMapping("/users")
    public ResponseEntity<AdminAnalyticsDTO> getUserStats() {
        AdminAnalyticsDTO analytics = adminAnalyticsService.getUserAnalytics();
        return ResponseEntity.ok(analytics);
    }

    /**
     * 获取销售分类统计
     */
    @GetMapping("/categories")
    public ResponseEntity<AdminAnalyticsDTO> getCategoryStats() {
        AdminAnalyticsDTO analytics = adminAnalyticsService.getCategoryAnalytics();
        return ResponseEntity.ok(analytics);
    }

    /**
     * 获取订单状态统计
     */
    @GetMapping("/orders/status")
    public ResponseEntity<List<Map<String, Object>>> getOrderStatusStats() {
        List<Map<String, Object>> stats = adminAnalyticsService.getOrderStatusStats();
        return ResponseEntity.ok(stats);
    }

    /**
     * 获取指定日期范围内的订单状态统计
     */
    @GetMapping("/orders/status/range")
    public ResponseEntity<List<Map<String, Object>>> getOrderStatusStatsByDateRange(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        List<Map<String, Object>> stats = adminAnalyticsService.getOrderStatusStatsByDateRange(startDate, endDate);
        return ResponseEntity.ok(stats);
    }
} 