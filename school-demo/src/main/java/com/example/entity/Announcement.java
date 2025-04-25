package com.example.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Announcement {
    private Integer announcementId;
    private String status;  // 活动、通知、最新、紧急
    private String title;
    private LocalDateTime publishDate;
    private String content;
} 