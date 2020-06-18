package com.example.demo.service;

import com.example.demo.common.ServerResponse;
import com.example.demo.pojo.User;
import org.springframework.stereotype.Service;


public interface UserService {

    ServerResponse addUser(User user);

    ServerResponse queryUserById(String id);

    ServerResponse deleteUserById(String id);
    ServerResponse updateUser(User user);
}
