package com.example.demo.service.impl;

import com.example.demo.entity.Customer;
import com.example.demo.resp.CustomerRepository;
import com.example.demo.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;




@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerRepository repository;
    @Transactional
    @Override
    public void save() {
        Customer customer1 =new Customer();
        customer1.setName("haha11111");
        repository.save(customer1);
        save2();
    }
    @Transactional
    @Override
    public void save2() {

        Customer customer2 =new Customer();
        customer2.setName("haha2");
        repository.save(customer2);
        int i =1/0;
    }
}
