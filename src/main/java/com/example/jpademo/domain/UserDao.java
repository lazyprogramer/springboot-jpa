package com.example.jpademo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
//    List<User> findAll();
//    User save(User user);
//    User findOne(long id);
//    User saveAndFlush(User user);
//    void delete(User user);
//    void delete(long id);
}
