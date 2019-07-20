package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {

    User save(User user);

    User save2(User user);

    void save3(User user) throws IllegalAccessException;

}
