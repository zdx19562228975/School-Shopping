package com.example.controller;

import com.example.entity.Comments;
import com.example.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {
    @Autowired
    private CommentsService commentsService;

    @Value("${file.upload-dir}")
    private String uploadDir;

    @GetMapping
    public ResponseEntity<List<Comments>> findAll() {
        return ResponseEntity.ok(commentsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comments> findById(@PathVariable Integer id) {
        Comments comment = commentsService.findById(id);
        return comment != null ? ResponseEntity.ok(comment) : ResponseEntity.notFound().build();
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Comments>> findByProductId(@PathVariable Integer productId) {
        return ResponseEntity.ok(commentsService.findByProductId(productId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Comments>> findByUserId(@PathVariable Integer userId) {
        return ResponseEntity.ok(commentsService.findByUserId(userId));
    }

    @GetMapping("/check")
    public ResponseEntity<Boolean> checkCommentExists(
            @RequestParam Integer userId,
            @RequestParam Integer productId) {
        return ResponseEntity.ok(commentsService.checkCommentExists(userId, productId));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Comments comment) {
        return commentsService.insert(comment) ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Comments comment) {
        comment.setId(id);
        return commentsService.update(comment) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        return commentsService.deleteById(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        String imageUrl = commentsService.uploadImage(file);
        return imageUrl != null ? ResponseEntity.ok(imageUrl) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/image/{filename:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable String filename) {
        try {
            Path filePath = Paths.get(uploadDir).resolve(filename).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_JPEG)
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (MalformedURLException e) {
            return ResponseEntity.badRequest().build();
        }
    }
} 