package com.example.service.impl;

import com.example.entity.UserAccount;
import com.example.mapper.UserAccountMapper;
import com.example.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

@Service
public class UserAccountServiceImpl implements UserAccountService {
    @Autowired
    private UserAccountMapper userAccountMapper;

    @Override
    public List<UserAccount> findAll() {
        return userAccountMapper.findAll();
    }

    @Override
    public UserAccount findById(Integer id) {
        return userAccountMapper.findById(id);
    }

    @Override
    public UserAccount findByAccount(String account) {
        return userAccountMapper.findByAccount(account);
    }

    @Override
    public UserAccount findByEmail(String email) {
        return userAccountMapper.findByEmail(email);
    }

    @Override
    public boolean insert(UserAccount user) {
        return userAccountMapper.insert(user) > 0;
    }

    @Override
    public boolean update(UserAccount user) {
        return userAccountMapper.update(user) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return userAccountMapper.deleteById(id) > 0;
    }

    @Override
    public UserAccount login(String account, String password) {
        UserAccount user = findByAccount(account);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("登录成功");
            return user;
        }
        return null;
    }

    @Override
    public boolean register(UserAccount user) {
        // 检查邮箱和手机号是否已存在
        if (isEmailExists(user.getEmail())) {
            throw new RuntimeException("邮箱已被注册");
        }
        if (user.getPhoneNumber() != null && isPhoneExists(user.getPhoneNumber())) {
            throw new RuntimeException("手机号已被注册");
        }
        
        // 设置创建时间
        user.setCreateAt(LocalDateTime.now());
        return insert(user);
    }

    @Override
    public boolean isEmailExists(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return userAccountMapper.checkEmailExists(email) > 0;
    }

    @Override
    public boolean isPhoneExists(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            return false;
        }
        return userAccountMapper.checkPhoneExists(phoneNumber) > 0;
    }
} 