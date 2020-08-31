package com.sign.controller;

import com.sign.bean.User;
import com.sign.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user/save")
    public User save(@RequestParam String name) {
        User user = new User();
        user.setName(name);
        userRepository.save(user);
        return user;
    }

}
