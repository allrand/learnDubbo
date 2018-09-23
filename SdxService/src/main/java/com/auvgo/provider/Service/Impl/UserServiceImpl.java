package com.auvgo.provider.Service.Impl;

import com.auvgo.api.UserService;
import com.auvgo.entity.User;
import com.auvgo.provider.dao.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserMapper userMapper;

    public List<User> getUsers() {
        if (userMapper == null){
            logger.error("UserMapper obj: {}", userMapper);
            throw new IllegalAccessError("internal error!!!");
        }
        return userMapper.selectUsers();
    }

    @Override
    public int addUser(User user) {
        userMapper.insertUser(user);
        return 0;
    }

    @Override
    public int delUser(User user) {
        userMapper.deleteUser(user);
        return 0;
    }

    @Override
    public int updateUser(User user) {
        userMapper.updateUser(user);
        return 0;
    }


}
