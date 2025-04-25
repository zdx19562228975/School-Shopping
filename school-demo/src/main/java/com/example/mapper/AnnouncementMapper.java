package com.example.mapper;

import com.example.entity.Announcement;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AnnouncementMapper {
    List<Announcement> findAll();
    Announcement findById(Integer announcementId);
    List<Announcement> findByStatus(String status);
    List<Announcement> findLatest(int limit);
    int insert(Announcement announcement);
    int update(Announcement announcement);
    int deleteById(Integer announcementId);
} 