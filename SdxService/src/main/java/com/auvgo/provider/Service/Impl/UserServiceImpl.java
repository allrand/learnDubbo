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
//            return null;
        }
        return userMapper.selectUsers();
    }


    private Map<String, Object> kvmap = new HashMap<String, Object>();

    public Object getValue(String key) {
        logger.info("key: {}", key);
        if (key == null || key.equals(""))
            throw new IllegalArgumentException("key is null!");

        return kvmap.get(key);

    }

    public void setValue(String key, Object value) {
        logger.info("key: {} value: {}", key, value);
        if (key == null || key.equals(""))
            throw new IllegalArgumentException("key is null!");
        if (value == null)
            throw new IllegalArgumentException("value is null!");

        kvmap.put(key, value);
    }

    public void delValue(String key) {

    }

    public void updateValue(String key, Object value) {

    }

}
