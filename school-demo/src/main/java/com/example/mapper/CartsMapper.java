package com.example.mapper;

import com.example.entity.Carts;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface CartsMapper {
    @Insert("INSERT INTO carts (product_id, user_id, quantity, created_at) VALUES (#{productId}, #{userId}, #{quantity}, #{createdAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Carts cart);

    @Select("SELECT * FROM carts WHERE id = #{id}")
    Carts findById(int id);

    @Select("SELECT * FROM carts WHERE user_id = #{userId}")
    List<Carts> findByUserId(int userId);

    @Delete("DELETE FROM carts WHERE product_id = #{productId} AND user_id = #{userId}")
    void removecarts(@Param("productId") Integer productId, @Param("userId") Integer userId);

    @Update("UPDATE carts SET product_id = #{productId}, user_id = #{userId}, quantity = #{quantity}, created_at = #{createdAt} WHERE id = #{id}")
    void update(Carts cart);

    @Delete("DELETE FROM carts WHERE id = #{id}")
    void deleteById(int id);

    @Select("SELECT COUNT(*) FROM carts WHERE product_id = #{productId} AND user_id = #{userId}")
    Integer checkcarts(@Param("productId") Integer productId, @Param("userId") Integer userId);
}