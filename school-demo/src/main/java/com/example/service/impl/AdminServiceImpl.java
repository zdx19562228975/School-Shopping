package com.example.service.impl;

import com.example.entity.Admin;
import com.example.mapper.AdminMapper;
import com.example.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<Admin> findAll() {
        return adminMapper.findAll();
    }

    @Override
    public Admin findById(Integer id) {
        return adminMapper.findById(id);
    }

    @Override
    public Admin findByAccount(String account) {
        return adminMapper.findByAccount(account);
    }

    @Override
    public boolean insert(Admin admin) {
        return adminMapper.insert(admin) > 0;
    }

    @Override
    public boolean update(Admin admin) {
        return adminMapper.update(admin) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return adminMapper.deleteById(id) > 0;
    }

    @Override
    public Admin login(String account, String password) {
        Admin admin = findByAccount(account);
        if (admin != null && admin.getPassword().equals(password)) {
            return admin;
        }
        return null;
    }
} 