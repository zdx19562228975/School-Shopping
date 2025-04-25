package com.example.mapper;

import com.example.entity.Likes;
import org.apache.ibatis.annotations.*;

@Mapper
public interface LikesMapper {
    @Insert("INSERT INTO likes (product_id, user_id) VALUES (#{productId}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addLike(Likes likes);

    @Delete("DELETE FROM likes WHERE product_id = #{productId} AND user_id = #{userId}")
    void removeLike(@Param("productId") Integer productId, @Param("userId") Integer userId);

    @Select("SELECT COUNT(*) FROM likes WHERE product_id = #{productId}")
    Integer countLikesByProductId(@Param("productId") Integer productId);

    @Select("SELECT COUNT(*) FROM likes WHERE product_id = #{productId} AND user_id = #{userId}")
    Integer checkLike(@Param("productId") Integer productId, @Param("userId") Integer userId);
}