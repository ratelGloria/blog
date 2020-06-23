package com.example.demo.service;

import com.example.demo.common.ServerResponse;
import com.example.demo.dao.UserMapper;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public ServerResponse addUser(User user) {

        int i = userMapper.addUser(user);

        if(i>0){
            return ServerResponse.serverResponseSuccess(user);
        }
        return ServerResponse.serverResponseUnSuccess();
    }

    @Override
    public ServerResponse queryUserById(String id) {
        User user = userMapper.queryUserById(id);

        if(user != null){
            return ServerResponse.serverResponseSuccess(user);
        }
        return ServerResponse.serverResponseUnSuccess();
    }

    @Override
    public ServerResponse deleteUserById(String id) {

        int i = userMapper.deleteUserById(id);
        if(i>0){
            return ServerResponse.serverResponseSuccess();
        }
        return ServerResponse.serverResponseUnSuccess();
    }

    @Override
    public ServerResponse updateUser(User user) {

        int i = userMapper.updateUser(user);

        if(i>0){
            return ServerResponse.serverResponseSuccess();
        }
        return ServerResponse.serverResponseUnSuccess();
    }


}
