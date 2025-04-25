package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Orders;
import com.example.dto.OrderDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

public interface OrdersService extends IService<Orders> {
    // 创建订单
    OrderDTO createOrder(OrderDTO orderDTO);
    
    // 更新订单状态
    boolean updateOrderStatus(Integer orderId, String status);
    
    // 获取订单详情
    OrderDTO getOrderDetail(Integer orderId);
    
    // 分页查询订单列表
    IPage<OrderDTO> getOrderList(Page<Orders> page, Integer userId);
    
    // 取消订单
    boolean cancelOrder(Integer orderId);

    IPage<OrderDTO> getOrderListAll(Page<Orders> page);
}