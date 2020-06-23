package com.example.demo.controller;

import com.example.demo.common.ServerResponse;
import com.example.demo.pojo.User;
import com.example.demo.redis.IRedisService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    User user;

    @Autowired
    IRedisService iRedisService;

    @RequestMapping("in/{username}/{pwd}")
    public ServerResponse login(@PathVariable("username") String username,@PathVariable("pwd") String pwd){
        if (username.equals("")||username==null||pwd.equals("")||pwd==null) {
            return ServerResponse.serverResponseUnSuccess("数据不全");
        }
        ServerResponse serverResponse = userService.queryUserById(username);
        User userInfo = (User)serverResponse.getData();

        if(pwd.equals(userInfo.getPassword())){
            return ServerResponse.serverResponseSuccess();
        }
        return ServerResponse.serverResponseUnSuccess();
    }

    @RequestMapping("up/{id}/{pwd}")
    public ServerResponse signUp(@PathVariable("id") String id,@PathVariable("pwd") String pwd){
        if (id.equals("")||id==null||pwd.equals("")||pwd==null) {
            return ServerResponse.serverResponseUnSuccess("数据不全");
        }
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String format = simpleDateFormat.format(new Date());
//        String timeStamp = "";
//        try {
////            timeStamp = String.valueOf(simpleDateFormat.parse(format).getTime()/1000);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        String timeStamp = String.valueOf(System.currentTimeMillis());
        user.setId(id);
        user.setPassword(pwd);
        user.setCreateTime(timeStamp);
        ServerResponse serverResponse = userService.addUser(user);
        User userInfo = (User)serverResponse.getData();

        if(userInfo != null && pwd.equals(userInfo.getPassword())){
            HashMap<String, String> userInfoMap = new HashMap<String, String>();
            userInfoMap.put("id",userInfo.getId());
            
            iRedisService.setValue("userInfo_"+userInfo.getId(),userInfoMap);
            return ServerResponse.serverResponseSuccess(userInfo);
        }
        return ServerResponse.serverResponseUnSuccess();
    }

    @RequestMapping("update")
    public ServerResponse updateUser(@RequestParam("username") String username, @RequestParam("pwd") String pwd,@RequestParam("ico") String ico,@RequestParam("email") String email){
        if (username.equals("")||username==null||pwd.equals("")||pwd==null) {
            return ServerResponse.serverResponseUnSuccess("数据不全");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(new Date());
        user.setPassword(pwd);
        user.setUpdateTime(format);
        user.setEmail(email);
        user.setIco(ico);
        ServerResponse serverResponse = userService.updateUser(user);
        if(serverResponse.getStatus()==1){
            return ServerResponse.serverResponseSuccess();
        }else{
            return ServerResponse.serverResponseUnSuccess();
        }

    }
}
