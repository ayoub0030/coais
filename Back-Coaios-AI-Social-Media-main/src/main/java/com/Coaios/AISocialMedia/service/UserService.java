package com.Coaios.AISocialMedia.service;


import com.Coaios.AISocialMedia.domain.entities.Post;
import com.Coaios.AISocialMedia.domain.entities.User;
import com.Coaios.AISocialMedia.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@SuppressWarnings("unused")
@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User getUserById(Long id) {
        User user = userRepo.findById(id).get();
        user.setPosts(null);
        return user;
    }
    
    public List<User> getAllUsers() {
        List<User> users = userRepo.findAll();
        Iterator<User> iter = users.iterator();
        while(iter.hasNext()) {
            User user = iter.next();
            user.setPosts(null); // Avoid circular references
        }
        return users;
    }
}
