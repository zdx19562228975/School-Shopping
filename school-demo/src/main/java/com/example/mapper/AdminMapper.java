package com.example.mapper;

import com.example.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminMapper {
    List<Admin> findAll();
    Admin findById(Integer id);
    Admin findByAccount(String account);
    int insert(Admin admin);
    int update(Admin admin);
    int deleteById(Integer id);
} 