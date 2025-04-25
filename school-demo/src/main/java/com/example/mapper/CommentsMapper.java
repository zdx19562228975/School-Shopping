package com.example.mapper;

import com.example.entity.Comments;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentsMapper {
    List<Comments> findAll();
    Comments findById(Integer id);
    List<Comments> findByProductId(Integer productId);
    List<Comments> findByUserId(Integer userId);
    int insert(Comments comments);
    int update(Comments comments);
    int deleteById(Integer id);
    Comments checkCommentExists(Integer userId, Integer productId);
}
