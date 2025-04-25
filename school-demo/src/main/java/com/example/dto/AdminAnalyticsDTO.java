package com.example.dto;

import java.math.BigDecimal;
import java.util.List;

public class AdminAnalyticsDTO {
    private List<String> orderDates;           // 订单日期列表
    private List<Integer> orderCounts;         // 订单数量列表
    private List<String> revenueDates;         // 收入日期列表
    private List<BigDecimal> revenueAmounts;   // 收入金额列表
    private BigDecimal totalRevenue;           // 总收入
    private BigDecimal previousTotalRevenue;   // 前一天总收入
    private Integer totalOrders;               // 总订单数
    private Integer previousTotalOrders;       // 前一天总订单数
    private Integer totalProducts;             // 总商品数
    private Integer previousTotalProducts;     // 前一天总商品数
    private Integer activeProducts;            // 在售商品数
    private Integer totalUsers;                // 总用户数
    private Integer previousTotalUsers;        // 前一天总用户数
    private Integer activeUsers;               // 活跃用户数
    private BigDecimal averageOrderAmount;     // 平均订单金额
    private List<String> categories;           // 商品分类列表
    private List<Integer> categorySales;       // 分类销售数量
    private List<String> userGrowthDates;      // 用户增长日期列表
    private List<Integer> userGrowthCounts;    // 用户增长数量列表
    // 订单状态统计
    private Integer pendingPaymentOrders;      // 待付款订单数
    private Integer pendingShipmentOrders;     // 待发货订单数
    private Integer shippedOrders;             // 已发货订单数
    private Integer completedOrders;           // 已完成订单数
    private Integer cancelledOrders;           // 已取消订单数
    private Integer refundPendingOrders;       // 退货申请中订单数
    private Integer refundedOrders;            // 已退货订单数

    // Getters and Setters
    public List<String> getOrderDates() {
        return orderDates;
    }

    public void setOrderDates(List<String> orderDates) {
        this.orderDates = orderDates;
    }

    public List<Integer> getOrderCounts() {
        return orderCounts;
    }

    public void setOrderCounts(List<Integer> orderCounts) {
        this.orderCounts = orderCounts;
    }

    public List<String> getRevenueDates() {
        return revenueDates;
    }

    public void setRevenueDates(List<String> revenueDates) {
        this.revenueDates = revenueDates;
    }

    public List<BigDecimal> getRevenueAmounts() {
        return revenueAmounts;
    }

    public void setRevenueAmounts(List<BigDecimal> revenueAmounts) {
        this.revenueAmounts = revenueAmounts;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public BigDecimal getPreviousTotalRevenue() {
        return previousTotalRevenue;
    }

    public void setPreviousTotalRevenue(BigDecimal previousTotalRevenue) {
        this.previousTotalRevenue = previousTotalRevenue;
    }

    public Integer getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(Integer totalOrders) {
        this.totalOrders = totalOrders;
    }

    public Integer getPreviousTotalOrders() {
        return previousTotalOrders;
    }

    public void setPreviousTotalOrders(Integer previousTotalOrders) {
        this.previousTotalOrders = previousTotalOrders;
    }

    public Integer getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(Integer totalProducts) {
        this.totalProducts = totalProducts;
    }

    public Integer getPreviousTotalProducts() {
        return previousTotalProducts;
    }

    public void setPreviousTotalProducts(Integer previousTotalProducts) {
        this.previousTotalProducts = previousTotalProducts;
    }

    public Integer getActiveProducts() {
        return activeProducts;
    }

    public void setActiveProducts(Integer activeProducts) {
        this.activeProducts = activeProducts;
    }

    public Integer getTotalUsers() {
        return totalUsers;
    }

    public void setTotalUsers(Integer totalUsers) {
        this.totalUsers = totalUsers;
    }

    public Integer getPreviousTotalUsers() {
        return previousTotalUsers;
    }

    public void setPreviousTotalUsers(Integer previousTotalUsers) {
        this.previousTotalUsers = previousTotalUsers;
    }

    public Integer getActiveUsers() {
        return activeUsers;
    }

    public void setActiveUsers(Integer activeUsers) {
        this.activeUsers = activeUsers;
    }

    public BigDecimal getAverageOrderAmount() {
        return averageOrderAmount;
    }

    public void setAverageOrderAmount(BigDecimal averageOrderAmount) {
        this.averageOrderAmount = averageOrderAmount;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<Integer> getCategorySales() {
        return categorySales;
    }

    public void setCategorySales(List<Integer> categorySales) {
        this.categorySales = categorySales;
    }

    public List<String> getUserGrowthDates() {
        return userGrowthDates;
    }

    public void setUserGrowthDates(List<String> userGrowthDates) {
        this.userGrowthDates = userGrowthDates;
    }

    public List<Integer> getUserGrowthCounts() {
        return userGrowthCounts;
    }

    public void setUserGrowthCounts(List<Integer> userGrowthCounts) {
        this.userGrowthCounts = userGrowthCounts;
    }

    public Integer getPendingPaymentOrders() {
        return pendingPaymentOrders;
    }

    public void setPendingPaymentOrders(Integer pendingPaymentOrders) {
        this.pendingPaymentOrders = pendingPaymentOrders;
    }

    public Integer getPendingShipmentOrders() {
        return pendingShipmentOrders;
    }

    public void setPendingShipmentOrders(Integer pendingShipmentOrders) {
        this.pendingShipmentOrders = pendingShipmentOrders;
    }

    public Integer getShippedOrders() {
        return shippedOrders;
    }

    public void setShippedOrders(Integer shippedOrders) {
        this.shippedOrders = shippedOrders;
    }

    public Integer getCompletedOrders() {
        return completedOrders;
    }

    public void setCompletedOrders(Integer completedOrders) {
        this.completedOrders = completedOrders;
    }

    public Integer getCancelledOrders() {
        return cancelledOrders;
    }

    public void setCancelledOrders(Integer cancelledOrders) {
        this.cancelledOrders = cancelledOrders;
    }

    public Integer getRefundPendingOrders() {
        return refundPendingOrders;
    }

    public void setRefundPendingOrders(Integer refundPendingOrders) {
        this.refundPendingOrders = refundPendingOrders;
    }

    public Integer getRefundedOrders() {
        return refundedOrders;
    }

    public void setRefundedOrders(Integer refundedOrders) {
        this.refundedOrders = refundedOrders;
    }
} 