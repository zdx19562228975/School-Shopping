package com.example.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class ProductAnalyticsDTO {
    private Integer productId;
    private String productName;
    private String category;
    private BigDecimal price;
    private String description;
    private Integer stock;
    private String imageUrl;
    private Integer favoriteCount;
    private Integer likeCount;
    private Integer commentCount;
    private Integer purchaseCount;
    private Integer viewCount;
    private List<Date> purchaseDates;
    private BigDecimal totalSales;    // 总销售额
    private List<BigDecimal> dailySales;  // 每日销售额
    private List<Date> salesDates;    // 销售日期
    private Integer dailyViews;       // 日访问量
    private Double conversionRate;    // 转化率（购买数/访问数）
} 