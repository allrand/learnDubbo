package com.auvgo.provider.Service.Impl;

import com.auvgo.entity.User;
import com.auvgo.provider.dao.UserDaoTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:application-context.xml"})
public class UserServiceImplTest {
    private static Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
    @Autowired
    private UserServiceImpl userService;

    @Test
    public void getUsers() {
        List<User> users = userService.getUsers();
//        logger.info(users.toArray().toString());
        System.out.println(users.toArray().toString());
        users.forEach(user -> logger.info(user.getId() + "," + user.getUsername() + "," + user.getAddress()));
    }

    @Test
    public void getUser() {
        User user1 = userService.getUser(1);
        System.out.println(user1.toString());
//        logger.info(user1.toString());

    }

}