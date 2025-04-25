package com.example.service;

import com.example.entity.Admin;
import java.util.List;

public interface AdminService {
    List<Admin> findAll();
    Admin findById(Integer id);
    Admin findByAccount(String account);
    boolean insert(Admin admin);
    boolean update(Admin admin);
    boolean deleteById(Integer id);
    
    // 添加登录方法
    Admin login(String account, String password);
} 