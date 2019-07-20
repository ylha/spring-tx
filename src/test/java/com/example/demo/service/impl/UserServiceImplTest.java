package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.resp.UserRepository;
import com.example.demo.service.CustomerService;
import com.example.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    CustomerService customerService;

    /**
     * 测试 事物是否正常，数据库表中的数据为空
     * 确实测试出问题了，再确定代码无误的情况下，请考虑数据库的存储引擎
     */
    @Test
    public void testSave() {
        User user = new User();
        user.setName("hhhh4");
        user.setEmail("nihao@163.com4");
        userService.save(user);
    }

    /**
     * 事物正常回滚
     * save中为运行时异常  int i=1/0
     */
    @Test
    public void testSave1() {
        User user = new User();
        user.setName("hhhh4");
        user.setEmail("nihao@163.com4");
        userService.save(user);
    }

    /**
     * 同一个类中save方法没有事物的方法，save2有事物的方法
     * 事物不会发生回滚，事物被忽略
     * <p>
     * 原因：只有目标方法由外部调用，目标方法才由 Spring 生成的代理对象来管理
     */
    @Test
    public void testSave5() {
        User user = new User();
        user.setName("hhhh5");
        user.setEmail("nihao@163.com5");
        userService.save(user);
    }

    /**
     * 同一个类中俩个方法都有事物
     * 会发生回滚
     */
    @Test
    public void testSave6() {
        User user = new User();
        user.setName("hhhh6");
        user.setEmail("nihao@163.com6");
        userService.save(user);
    }


    /**
     * 同一个类中 save 方法有事物，save2 没有事物
     * 会发生回滚
     */
    @Test
    public void testSave7() {
        User user = new User();
        user.setName("hhhh7");
        user.setEmail("nihao@163.com7");
        userService.save(user);
    }

    /**
     * 测试方法3
     */
    @Test
    public void testSave8() throws IllegalAccessException {
        User user = new User();
        user.setName("hhhh8");
        user.setEmail("nihao@163.com8");
        userService.save3(user);
    }


    @Test
    public void testSave9() throws IllegalAccessException {
        User user = new User();
        user.setName("hhhh8");
        user.setEmail("nihao@163.com8");
        userService.save3(user);
    }


    /**
     * 重点  应该由外部直接调用俩个方法，避免方法2 没有被增强
     * 事物2 方法被 没有被增强，所以事物并没有被回滚
     */
    @Test
    public void testSave10() {
        customerService.save();
    }


}