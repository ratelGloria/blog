package com.example.demo.controller;


import com.example.demo.common.ServerResponse;
import com.example.demo.pojo.Blogs;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/WantToWrite")
public class WantToWriteController {

    @Autowired
    BlogService blogService;

    @RequestMapping("addMessage/{title}/{content}")
    public ServerResponse addMessage(@PathVariable("title") String title,@PathVariable("content") String content){
        System.out.println("-----i come in----aaa--");
        Blogs blogs = new Blogs();
        blogs.setContent(content);
        blogs.setTitile(title);

        return blogService.addMessage(blogs);
//无知使我对这个世界充满好奇
    }
}
