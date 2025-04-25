package com.example.service.impl;

import com.example.entity.Announcement;
import com.example.mapper.AnnouncementMapper;
import com.example.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {
    @Autowired
    private AnnouncementMapper announcementMapper;

    @Override
    public List<Announcement> findAll() {
        return announcementMapper.findAll();
    }

    @Override
    public Announcement findById(Integer announcementId) {
        return announcementMapper.findById(announcementId);
    }

    @Override
    public List<Announcement> findByStatus(String status) {
        return announcementMapper.findByStatus(status);
    }

    @Override
    public List<Announcement> findLatest(int limit) {
        return announcementMapper.findLatest(limit);
    }

    @Override
    public boolean insert(Announcement announcement) {
        // 设置发布时间为当前时间
        announcement.setPublishDate(LocalDateTime.now());
        return announcementMapper.insert(announcement) > 0;
    }

    @Override
    public boolean update(Announcement announcement) {
        return announcementMapper.update(announcement) > 0;
    }

    @Override
    public boolean deleteById(Integer announcementId) {
        return announcementMapper.deleteById(announcementId) > 0;
    }
} 