package com.example.demo.controller;


import com.example.demo.common.HttpAttributes;
import com.example.demo.common.ServerResponse;
import com.example.demo.pojo.Blogs;
import com.example.demo.pojo.User;
import com.example.demo.redis.IRedisServiceImp;
import com.example.demo.service.BlogService;
import io.netty.handler.codec.base64.Base64Decoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;

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

    @RequestMapping("addBlog")
    public ServerResponse addBlog(@RequestParam(value = "title",required = false) String title,@RequestParam(value = "content",required = false) String content,
                                  @RequestParam(value = "url",required = true)String url){

        HttpSession session = httpAttributes.getSession();
//        session.setAttribute("username","aaaaaa");
        System.out.println(session.getId());
        System.out.println(session.getAttributeNames());
        System.out.println(session.getAttribute("username"));
        session.setMaxInactiveInterval(10);
        String username = (String)session.getAttribute("username");
        String sessionId = session.getId();

//        25C71F9346ACC7D192D48F610DCADA65
        String userValueSessionId = (String)iredisServiceImp.getValue(username);
        System.out.println(userValueSessionId+"=========="+sessionId);
        System.out.println(session.getAttribute("username")+"==========");
//        Blogs blogs = new Blogs();
        if(userValueSessionId.equals(sessionId)  && !session.getAttribute("username").equals("") && session.getAttribute("username")!=null){
            blogs.setContent(content);
            blogs.setTitile(title);
            blogs.setAuthor(username);
            blogs.setCreateTime(System.currentTimeMillis());
            blogs.setUpdateTime(System.currentTimeMillis());
            return blogService.addBlog(blogs);
        }
        return ServerResponse.serverResponseUnSuccess("请登录");
//无知使我对这个世界充满好奇
    }

    @RequestMapping("addImg")
    public ServerResponse addImg(@RequestParam(value = "imgUrl",required = false)String imgUrl){
        System.out.println("--------ooo-----"+imgUrl);
        return null;
    }

    @RequestMapping("addImgMap")
    public ServerResponse addImgMap(@RequestParam HashMap map){
        System.out.println("--------ooo-----"+map.toString());
        BASE64Decoder base64Decoder = new BASE64Decoder();
        byte[] imgUrls = new byte[0];
        try {
            imgUrls = base64Decoder.decodeBuffer((String) map.get("imgUrl"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("--------ooo-----"+imgUrls.toString());
        return null;


        /*
        * <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="../css/testPage.css">
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
</head>
<body>
<form enctype="multipart/form-data">
    <input type="file" id="img">
    <div id="div1"><img src=""></div>

    <div style="width: 60px;height: 30px;background-color: aqua" id="commit">走你</div>
</form>

</body>

<script>

    $(function () {

        $("#commit").on("click",function () {
console.log($("#div1 img").attr("src"))
            $.ajax({
                url:"http://192.168.1.122:8051/WantToWrite/addImgMap",
                type:"post",
                dataType:"json",
                // contentType: 'application/json; charset=utf-8',
                data:{"imgUrl":$("#div1 img").attr("src")},

            })
        })

        $("#img").on("change",function (evt) {
            var c = evt.target.files[0]
            // var c = evt.files[0];

            var reader = new FileReader();
            reader.onload = function(a){
                var w = a.target.result;
                $("#div1 img").attr("src",w)
            }
            reader.readAsDataURL(c);
        })
    })

</script>

</html>
        * */
    }

    /*
    * image
    *
    * id
    * blog_id
    * url
    * create_time
    * update_time
    * if_deleted
    * type
    *
    * */

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
