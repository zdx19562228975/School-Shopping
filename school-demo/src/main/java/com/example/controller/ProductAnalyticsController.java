package com.example.controller;

import com.example.dto.ProductAnalyticsDTO;
import com.example.service.ProductAnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/analytics/products")
public class ProductAnalyticsController {
    @Autowired
    private ProductAnalyticsService productAnalyticsService;

    @GetMapping("/top-selling")
    public ResponseEntity<List<ProductAnalyticsDTO>> getTopSellingProducts(
            @RequestParam(defaultValue = "10") int limit) {
        return ResponseEntity.ok(productAnalyticsService.getTopSellingProducts(limit));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductAnalyticsDTO> getProductAnalytics(
            @PathVariable Integer productId) {
        ProductAnalyticsDTO analytics = productAnalyticsService.getProductAnalytics(productId);
        return analytics != null ? ResponseEntity.ok(analytics) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<ProductAnalyticsDTO>> getAllProductsAnalytics() {
        return ResponseEntity.ok(productAnalyticsService.getAllProductsAnalytics());
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<ProductAnalyticsDTO>> getProductAnalyticsByCategory(
            @PathVariable String category) {
        return ResponseEntity.ok(productAnalyticsService.getProductAnalyticsByCategory(category));
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<ProductAnalyticsDTO>> getProductAnalyticsByDateRange(
            @RequestParam String startDate,
            @RequestParam String endDate) {
        return ResponseEntity.ok(productAnalyticsService.getProductAnalyticsByDateRange(startDate, endDate));
    }
} 