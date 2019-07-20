package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.resp.UserRepository;
import com.example.demo.service.CustomerService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    CustomerService customerService;
    @Autowired
    UserRepository userRepository;

    //注意事物不是import javax.transaction.Transactional;
    // 而是import org.springframework.transaction.annotation.Transactional;

  /*  @Transactional
    @Override
    public User save(User user) {
        User save = userRepository.save(user);
        User user1 =new User();
        int a= 1/0;
        return save;
    }*/

    /*@Transactional
    @Override
    public User save(User user) {
        User save = userRepository.save(user);
        User user1 = new User();
        save2(user1);
        return save;
    }*/


    @Transactional
    @Override
    public User save(User user) {
        User save = userRepository.save(user);
        User user1 = new User();
        save2(user1);
        return save;
    }


    @Override
    public User save2(User user) {
        int i = 1 / 0;
        return null;
    }

    @Transactional
    @Override
    public void save3(User user) throws IllegalAccessException {
        User user3 =new User();
        user3.setName("a");
        user3.setEmail("aaaa");
        User save = userRepository.save(user3);
        throw new IllegalAccessException("不回滚");

    }




 /*   @Override
    public User save2(User user) {
        *//**
     * 事物是否会回滚？？
     *//*
        int i=1/0;
        userRepository.save(user);
    }*/


}
