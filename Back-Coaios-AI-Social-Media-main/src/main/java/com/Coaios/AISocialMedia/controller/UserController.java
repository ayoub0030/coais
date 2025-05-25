package com.Coaios.AISocialMedia.controller;


import com.Coaios.AISocialMedia.domain.entities.User;
import com.Coaios.AISocialMedia.repository.UserRepo;
import com.Coaios.AISocialMedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("unused")
@CrossOrigin
@RestController
@RequestMapping(path = "/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    
    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }
}
