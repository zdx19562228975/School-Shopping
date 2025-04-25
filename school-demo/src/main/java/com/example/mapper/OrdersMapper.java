package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Orders;
import com.example.dto.OrderDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {
    // 获取订单详情
    OrderDTO getOrderDetail(@Param("orderId") Integer orderId);
    
    // 获取用户订单列表
    List<OrderDTO> getOrderList(@Param("userId") Integer userId);

    List<OrderDTO> getOrderListAll();


} 