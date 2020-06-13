package com.example.demo.service;

import com.example.demo.common.ServerResponse;
import com.example.demo.pojo.Blogs;
import org.springframework.stereotype.Service;

@Service
public interface BlogService {

//    interface 接口，只能写public修饰的方法，实现接口必须实现全部方法

    ServerResponse addMessage(Blogs blogs);
}
