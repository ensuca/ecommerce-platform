package com.enesuca.ecommerceplatform.user.controller;

import com.enesuca.ecommerceplatform.user.model.User;
import com.enesuca.ecommerceplatform.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping("/find")
    public User findUserByUsername(@RequestParam String username) {
        return userService.findByUsername(username).orElse(null);
    }
}
