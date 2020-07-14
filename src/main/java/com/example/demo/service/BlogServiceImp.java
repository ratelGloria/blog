package com.example.demo.service;

import com.example.demo.common.ServerResponse;
import com.example.demo.dao.BlogsMapper;
import com.example.demo.pojo.Blogs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;


@Service
public class BlogServiceImp implements BlogService

{

    @Autowired
    BlogsMapper blogsMapper;

    @Override
    public ServerResponse addBlog(Blogs blogs) {

        int i = blogsMapper.addBlog(blogs);
        if(i==1){
            return ServerResponse.serverResponseSuccess("提交成功");
        }
        return ServerResponse.serverResponseUnSuccess("数据提交失败");
    }


    @Override
    public ServerResponse getBlogList(String type) {

        List<Blogs> blogs = blogsMapper.selectBlog(type);
        if(!blogs.isEmpty()){
            return ServerResponse.serverResponseSuccess(blogs);
        }

        return ServerResponse.serverResponseUnSuccess();
    }
}
