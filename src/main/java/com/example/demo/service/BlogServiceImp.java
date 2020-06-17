package com.example.demo.service;

import com.example.demo.common.ServerResponse;
import com.example.demo.dao.BlogsMapper;
import com.example.demo.pojo.Blogs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BlogServiceImp implements BlogService {

//    @Autowired
    BlogsMapper blogsMapper;

    @Override
    public ServerResponse addMessage(Blogs blogs) {

        int i = blogsMapper.addMessage(blogs);
        if(i==1){
            return ServerResponse.serverResponseSuccess("提交成功");
        }
        return ServerResponse.serverResponseUnSuccess("数据提交失败");
    }
}
