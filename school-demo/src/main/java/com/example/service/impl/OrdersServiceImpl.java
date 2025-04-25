package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Orders;
import com.example.mapper.OrdersMapper;
import com.example.service.OrdersService;
import com.example.dto.OrderDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

    @Override
    @Transactional
    public OrderDTO createOrder(OrderDTO orderDTO) {
        Orders order = new Orders();
        BeanUtils.copyProperties(orderDTO, order);
        // 计算总价
        if (orderDTO.getNumber() != null && orderDTO.getSinglePrice() != null) {
            order.setTotalPrice(orderDTO.getSinglePrice().multiply(new BigDecimal(orderDTO.getNumber())));
        }
        save(order);
        orderDTO.setId(order.getId());
        return orderDTO;
    }

    @Override
    @Transactional
    public boolean updateOrderStatus(Integer orderId, String status) {
        Orders order = getById(orderId);
        if (order == null) {
            return false;
        }
        order.setLogisticsStatus(status);
        return updateById(order);
    }

    @Override
    public OrderDTO getOrderDetail(Integer orderId) {
        return baseMapper.getOrderDetail(orderId);
    }

    @Override
    public IPage<OrderDTO> getOrderList(Page<Orders> page, Integer userId) {
        // 获取订单列表
        List<OrderDTO> orderList = baseMapper.getOrderList(userId);
        
        // 手动分页
        int start = (int) ((page.getCurrent() - 1) * page.getSize());
        int end = Math.min(start + (int) page.getSize(), orderList.size());
        
        Page<OrderDTO> dtoPage = new Page<>(page.getCurrent(), page.getSize(), orderList.size());
        dtoPage.setRecords(orderList.subList(start, end));
        
        return dtoPage;
    }

    @Override
    @Transactional
    public boolean cancelOrder(Integer orderId) {
        Orders order = getById(orderId);
        if (order == null) {
            return false;
        }
        order.setLogisticsStatus("已取消");
        return updateById(order);
    }
    @Override
    public IPage<OrderDTO> getOrderListAll(Page<Orders> page) {
        // 获取订单列表
        List<OrderDTO> orderList = baseMapper.getOrderListAll();

        // 手动分页
        int start = (int) ((page.getCurrent() - 1) * page.getSize());
        int end = Math.min(start + (int) page.getSize(), orderList.size());

        Page<OrderDTO> dtoPage = new Page<>(page.getCurrent(), page.getSize(), orderList.size());
        dtoPage.setRecords(orderList.subList(start, end));

        return dtoPage;
    }
} 