package com.example.controller;

import com.example.entity.Announcement;
import com.example.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/announcements")
public class AnnouncementController {
    @Autowired
    private AnnouncementService announcementService;

    @GetMapping
    public ResponseEntity<List<Announcement>> findAll() {
        return ResponseEntity.ok(announcementService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Announcement> findById(@PathVariable Integer id) {
        Announcement announcement = announcementService.findById(id);
        return announcement != null ? ResponseEntity.ok(announcement) : ResponseEntity.notFound().build();
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Announcement>> findByStatus(@PathVariable String status) {
        return ResponseEntity.ok(announcementService.findByStatus(status));
    }

    @GetMapping("/latest/{limit}")
    public ResponseEntity<List<Announcement>> findLatest(@PathVariable int limit) {
        return ResponseEntity.ok(announcementService.findLatest(limit));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Announcement announcement) {
        return announcementService.insert(announcement) ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Announcement announcement) {
        announcement.setAnnouncementId(id);
        return announcementService.update(announcement) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        return announcementService.deleteById(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
} 