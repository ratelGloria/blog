package com.example.demo;

import com.example.demo.controller.HelloWorldController;
import com.example.demo.controller.ItemController;
import com.example.demo.pojo.Item;
import javafx.application.Application;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//@RunWith(SpringJUnit4ClassRunner.class)  springboot1.4版本之前用的是SpringJUnit4ClassRunner.class
@RunWith(SpringRunner.class)

//@SpringApplicationConfiguration(classes = Application.class) 1.4版本之前使用
@SpringBootTest

//测试环境使用，用来表示测试环境使用的ApplicationContext 将是 WebApplicationContext 类型
/*关于这个WebApplicationContext
首先，javaee标准规定了，servlet容器需要在应用项目启动时，
给应用项目初始化一个ServletContext作为公共环境容易存放公共信息，ServletContext中的信息都是有容器提供的
启动web容器，执行流程
读配置文件节点->创建ServletContext->设置参数到Context中->监听listener并执行初始化方法和销毁方法

Spring分别提供了用户启动WebApplicationContext 合Web 容器监听器
org.springframework.web.context.ContextLoaderListener
org.springframework.web.context.ContextLoaderServlet
所有版本的WEB容器都可以定义自启动的servlet，
但只有2.3及以上的版本的web容器才支持web容器监听器，现在一般都使用Listener了

spring为我们提供的ioc容器，需要我们指定容器的配置文件，然后由改容器初始化并创建改容器，一定要使用contextConfigLocation作为参数名

项目启动时，会执行ContextLoaderListener的相关方法，
创建WebApplicationContext(web应用上下文)并以键值对形式存放于ServletContext

springIOC容器先根据监听初始化WebAppliactionContext，
然后再初始化web.xml中其他配置的servlet，为其初始化自己的上下文信息servletContext设置为它的父容器
所以最后的关系是ServletContext包含了WebApplicationContext，
WebApplicationContext包含了其他的Servlet上下文环境
* */
@WebAppConfiguration

public class Test {

    private MockMvc mvc;

    @Autowired
    private HelloWorldController helloWorldController;

    @Autowired
    private ItemController itemController;

    @Before
    public void setUp() throws Exception{
//        mvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();

        mvc = MockMvcBuilders.standaloneSetup(new ItemController()).build();

    }


    @org.junit.Test
    public void getHello() throws Exception{
//        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().string(equalTo("Hello World!")));

//        Assert.assertEquals(helloWorldController.getName(),"qqq");

//        Assert.assertEquals(helloWorldController.getNumber(),22);

        Item item = new Item();

        mvc.perform(MockMvcRequestBuilders.get("/item/2").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("")));

    }

}
