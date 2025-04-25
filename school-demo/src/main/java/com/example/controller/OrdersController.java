package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dto.OrderDTO;
import com.example.entity.Orders;
import com.example.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok(ordersService.createOrder(orderDTO));
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable Integer id) {
        OrderDTO orderDTO = ordersService.getOrderDetail(id);
        return orderDTO != null ? ResponseEntity.ok(orderDTO) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<IPage<OrderDTO>> getOrderList(
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) Integer userId) {
        Page<Orders> page = new Page<>(current, size);
        return ResponseEntity.ok(ordersService.getOrderList(page, userId));
    }

    @GetMapping("/all")
    public ResponseEntity<IPage<OrderDTO>> getOrderListAll(
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "10") Integer size) {
        Page<Orders> page = new Page<>(current, size);
        return ResponseEntity.ok(ordersService.getOrderListAll(page));
    }
    @PutMapping("/{id}/status")
    public ResponseEntity<Void> updateOrderStatus(
            @PathVariable Integer id,
            @RequestParam String status) {
        boolean success = ordersService.updateOrderStatus(id, status);
        return success ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @PostMapping("/{id}/cancel")
    public ResponseEntity<Void> cancelOrder(@PathVariable Integer id) {
        boolean success = ordersService.cancelOrder(id);
        return success ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
} 