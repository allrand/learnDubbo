package com.auvgo.provider.dao.mapper;

import com.auvgo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    List<User> selectUsers();
    User selectUser(Integer id);
    void insertUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
}
