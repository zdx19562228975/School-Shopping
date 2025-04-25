package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.UserAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserAccountMapper extends BaseMapper<UserAccount> {
    List<UserAccount> findAll();
    UserAccount findById(Integer id);
    UserAccount findByAccount(String account);
    UserAccount findByEmail(String email);
    int insert(UserAccount user);
    int update(UserAccount user);
    int deleteById(Integer id);
    
    @Select("SELECT COUNT(*) FROM user_account WHERE email = #{email}")
    int checkEmailExists(String email);
    
    @Select("SELECT COUNT(*) FROM user_account WHERE phone_number = #{phoneNumber}")
    int checkPhoneExists(String phoneNumber);
} 