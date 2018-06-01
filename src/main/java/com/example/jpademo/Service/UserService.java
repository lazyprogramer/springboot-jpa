package com.example.jpademo.Service;

import com.example.jpademo.dao.UserDao;
import com.example.jpademo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userRepository;

    public User findUserByName(String username) {
        return userRepository.findByUsername(username);
    }
}
