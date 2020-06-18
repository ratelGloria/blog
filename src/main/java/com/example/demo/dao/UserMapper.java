package com.example.demo.dao;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapper {
    int insert(User record);

    List<User> selectAll();

    int addUser(User user);

    int deleteUserById(String id);

    User queryUserById(String id);

    int updateUser(User user);
}