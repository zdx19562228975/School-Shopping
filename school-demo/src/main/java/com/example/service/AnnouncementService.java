package com.example.service;

import com.example.entity.Announcement;
import java.util.List;

public interface AnnouncementService {
    List<Announcement> findAll();
    Announcement findById(Integer announcementId);
    List<Announcement> findByStatus(String status);
    List<Announcement> findLatest(int limit);
    boolean insert(Announcement announcement);
    boolean update(Announcement announcement);
    boolean deleteById(Integer announcementId);
} 