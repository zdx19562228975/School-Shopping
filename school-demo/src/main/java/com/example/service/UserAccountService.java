package com.example.service;

import com.example.entity.UserAccount;
import java.util.List;

public interface UserAccountService {
    List<UserAccount> findAll();
    UserAccount findById(Integer id);
    UserAccount findByAccount(String account);
    UserAccount findByEmail(String email);
    boolean insert(UserAccount user);
    boolean update(UserAccount user);
    boolean deleteById(Integer id);
    
    // 新增登录方法
    UserAccount login(String account, String password);
    
    // 新增注册方法
    boolean register(UserAccount user);
    
    /**
     * 检查邮箱是否已存在
     * @param email 邮箱地址
     * @return true 如果邮箱已存在，false 如果邮箱不存在
     */
    boolean isEmailExists(String email);
    
    /**
     * 检查手机号是否已存在
     * @param phoneNumber 手机号
     * @return true 如果手机号已存在，false 如果手机号不存在
     */
    boolean isPhoneExists(String phoneNumber);
} 