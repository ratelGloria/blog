package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/*
* java -jar xxx.jar --server.port = 8888
* 修改application.properties属性
*  -- 代表赋值
*
* SpringApplication.setAddCommandLineProperties(false)
* 设置禁止通过命令行修改文件属性
* */
//@RestController
@Component
public class HelloWorldController {

    @Value("${com.qj.a.name}")
    private String name;

    @Value("${random.int(10)}")
//    @Value("${random.int[10,20]}")
//    @Value("${random.long}")
//    @Value("${random.value}") 随机字符串
    private int number;

    @RequestMapping("/hello")
    public String index(){
        return "Hello World!";
    }


    public String getName(){
        return  name;
    }

    public int getNumber(){
        return number;
    }

}
