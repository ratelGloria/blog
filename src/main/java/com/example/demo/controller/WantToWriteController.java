package com.example.demo.controller;


import com.example.demo.common.HttpAttributes;
import com.example.demo.common.ServerResponse;
import com.example.demo.pojo.Blogs;
import com.example.demo.pojo.User;
import com.example.demo.redis.IRedisServiceImp;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

@CrossOrigin
@RestController
@RequestMapping("/WantToWrite")
public class WantToWriteController {

    @Autowired
    BlogService blogService;

    @Autowired
    HttpAttributes httpAttributes;

    @Autowired
    IRedisServiceImp iredisServiceImp;

    @Autowired
    Blogs blogs;

    @RequestMapping("addMessage/{title}/{content}")
    public ServerResponse addMessage(@PathVariable("title") String title,@PathVariable("content") String content){

        HttpSession session = httpAttributes.getSession();
//        session.setAttribute("username","aaaaaa");
        System.out.println(session.getId());
        System.out.println(session.getAttributeNames());
        System.out.println(session.getAttribute("username"));
        session.setMaxInactiveInterval(10);
        String username = (String)session.getAttribute("username");
//        25C71F9346ACC7D192D48F610DCADA65
        User userValue = (User)iredisServiceImp.getValue(session.toString());
//        Blogs blogs = new Blogs();
        if(userValue != null && !session.getAttribute("username").equals("") && session.getAttribute("username")!=null){
            System.out.println("-----i come in----aaa--");
            blogs.setContent(content);
            blogs.setTitile(title);
            blogs.setAuthor(username);
            blogs.setCreateTime(System.currentTimeMillis());
            blogs.setUpdateTime(System.currentTimeMillis());
            return blogService.addMessage(blogs);
        }
        return ServerResponse.serverResponseUnSuccess();
//无知使我对这个世界充满好奇
    }

    @RequestMapping("getMessageList")
    public ServerResponse getMessageList(@RequestParam(value = "type",required = false) String type){

        HttpSession session = httpAttributes.getSession();

        String username = (String)session.getAttribute("username");

        if(!username.equals("") && username != null){

//            blogService

        }

        return null;
    }
}
