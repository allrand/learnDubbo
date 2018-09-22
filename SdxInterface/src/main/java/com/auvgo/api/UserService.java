package com.auvgo.api;

import com.auvgo.entity.User;

import java.util.List;

public interface UserService {
    Object getValue(String key);
    void setValue(String key, Object value);
    void delValue(String key);
    void updateValue(String key, Object value);

    List<User> getUsers();
}
