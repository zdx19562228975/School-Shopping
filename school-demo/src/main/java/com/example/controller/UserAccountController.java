package com.example.controller;

import com.example.entity.UserAccount;
import com.example.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {
    @Autowired
    private UserAccountService userAccountService;

    @GetMapping
    public ResponseEntity<List<UserAccount>> findAll() {
        return ResponseEntity.ok(userAccountService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAccount> findById(@PathVariable Integer id) {
        UserAccount user = userAccountService.findById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @GetMapping("/account/{account}")
    public ResponseEntity<UserAccount> findByAccount(@PathVariable String account) {
        UserAccount user = userAccountService.findByAccount(account);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserAccount> findByEmail(@PathVariable String email) {
        UserAccount user = userAccountService.findByEmail(email);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserAccount user) {
        return userAccountService.insert(user) ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody UserAccount user) {
        user.setId(id);
        return userAccountService.update(user) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        return userAccountService.deleteById(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @PostMapping("/login")
    public ResponseEntity<UserAccount> login(@RequestBody UserAccount user) {
        System.out.println(user.toString());
        user = userAccountService.login(user.getAccount(), user.getPassword());
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody UserAccount user) {
        return userAccountService.register(user) ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }

    @GetMapping("/validate/email")
    public ResponseEntity<?> checkEmail(@RequestParam String email) {
        try {
            boolean exists = userAccountService.isEmailExists(email);
            return ResponseEntity.ok(new HashMap<String, Object>() {{
                put("exists", exists);
                put("message", exists ? "邮箱已被注册" : "邮箱可以使用");
            }});
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new HashMap<String, Object>() {{
                    put("error", "检查邮箱失败");
                    put("message", e.getMessage());
                }});
        }
    }
    
    @GetMapping("/validate/phone")
    public ResponseEntity<?> checkPhone(@RequestParam String phoneNumber) {
        try {
            boolean exists = userAccountService.isPhoneExists(phoneNumber);
            return ResponseEntity.ok(new HashMap<String, Object>() {{
                put("exists", exists);
                put("message", exists ? "手机号已被注册" : "手机号可以使用");
            }});
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new HashMap<String, Object>() {{
                    put("error", "检查手机号失败");
                    put("message", e.getMessage());
                }});
        }
    }

    @GetMapping("/validate/account")
    public ResponseEntity<?> checkAccount(@RequestParam String account) {
        try {
            UserAccount existingUser = userAccountService.findByAccount(account);
            boolean exists = existingUser != null;
            return ResponseEntity.ok(new HashMap<String, Object>() {{
                put("exists", exists);
                put("message", exists ? "账号已被注册" : "账号可以使用");
            }});
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new HashMap<String, Object>() {{
                    put("error", "检查账号失败");
                    put("message", e.getMessage());
                }});
        }
    }
} 