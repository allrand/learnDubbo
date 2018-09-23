package com.auvgo.provider.dao;

import static org.junit.Assert.*;

import com.auvgo.entity.User;
import com.auvgo.provider.dao.mapper.UserMapper;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:application-context.xml"})
public class UserDaoTest {
    private static Logger logger = LoggerFactory.getLogger(UserDaoTest.class);

    @Autowired
    private UserMapper userMapper;

    @Test
    public void getAllUsers() {
        List<User> users = null;//userDao.getAllUsers();
        users = userMapper.selectUsers();

        logger.info(users.toArray().toString());
        users.forEach(user -> logger.info(user.getId() + "," + user.getUsername() + "," + user.getAddress()));

    }

    @Test
    public void addUser(){
        User user = new User();
        user.setUsername("xx");
        user.setAddress("BJ ..");
        user.setBirthday(new Date());
        user.setSex("1");
        userMapper.insertUser(user);
    }

    @Test
    public void updateUser(){
        User user = new User();
        user.setId(50);
        user.setUsername("A10 xx");
        user.setAddress("BJ CP");
        user.setBirthday(new Date());
        user.setSex("1");

        userMapper.updateUser(user);
    }

    @Test
    public void deleteUser(){
        User user = new User();
        user.setId(50);
        userMapper.deleteUser(user);
    }
//    public static void main(String[] args) {
//        testMybatis();
//    }

//    private static void testMybatis() {
//        System.out.println("hi");
//        // 获得Mybatis配置文件流
//        InputStream config = UserDaoTest.class.getClassLoader().getResourceAsStream("mybatis/mybatis.xml");
//        // 创建sql会话工厂
//        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(config);
//        //获得会话对象
//        SqlSession session = factory.openSession(true);
//        try {
//            //通过MyBatis实现接口UserDAO，返回实例
//            UserDao userDao = session.getMapper(UserDao.class);
//            List<User> users = null;//userDao.getAllUsers();
//
//            logger.info(users.toArray().toString());
//            users.forEach(user -> logger.info(user.getId() + "," + user.getUsername() + "," + user.getAddress()));
//        } finally {
//            session.close();
//        }
//    }
}