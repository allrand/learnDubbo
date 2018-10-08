package com.auvgo.api;

import com.auvgo.entity.User;
import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getUser(Integer id);
    int addUser(User user);
    int delUser(User user);
    int updateUser(User user);
}
