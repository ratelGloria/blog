package com.example.demo.controller;

import com.example.demo.common.ServerResponse;
import com.example.demo.pojo.User;
import com.example.demo.redis.IRedisService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
/*
处理跨域
* */
@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    User user;

    @Autowired
    IRedisService iRedisService;

    @Autowired
    ValueOperations valueOperations;

    @RequestMapping("in/{username}/{pwd}")
    public ServerResponse login(@PathVariable("username") String username,@PathVariable("pwd") String pwd){
        if (username.equals("")||username==null||pwd.equals("")||pwd==null) {
            return ServerResponse.serverResponseUnSuccess("数据不全");
        }
        ServerResponse serverResponse = userService.queryUserById(username);
        User userInfo = (User)serverResponse.getData();
System.out.println(userInfo+"----"+serverResponse.toString());
        if(serverResponse.getStatus() == 1 && userInfo != null && pwd.equals(userInfo.getPassword())){
            return ServerResponse.serverResponseSuccess(userInfo);
        }
        return ServerResponse.serverResponseUnSuccess();
    }

    @RequestMapping("redis/{username}")
    public ServerResponse redis(@PathVariable("username") String username){
        HashMap<String, String> stringHashMap = new HashMap<>();
        stringHashMap.put("1",username);
//        iRedisService.setValueString("test:one",username);

        valueOperations.set("1",username);
        return ServerResponse.serverResponseSuccess(valueOperations.get("1"));
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

    @RequestMapping("checkUserName/{username}")
    public ServerResponse checkUserName(@PathVariable("username") String username){

        ServerResponse serverResponse = userService.queryUserById(username);

        if(serverResponse.getStatus()==1){
            return ServerResponse.serverResponseUnSuccess();
        }
        return ServerResponse.serverResponseSuccess();
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
