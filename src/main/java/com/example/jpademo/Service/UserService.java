package com.example.jpademo.Service;

import com.example.jpademo.domain.UserDao;
import com.example.jpademo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userRepository;

    public User findUserByName(String username) {
        return userRepository.findByUsername(username);
    }
    public List<User> findAll() {return userRepository.findAll();}
    public User saveUser(User user) {return userRepository.save(user);}

    //TODO 无法找到findOne该方法
//    public User findUserById(long id) {
//        return userRepository.findOne();
//    }
    public User updateUser(User user) {return userRepository.saveAndFlush(user);}
    //TODO 无法找到delete方法
    public void deleteUser(long id) {userRepository.deleteById(id);}
}
