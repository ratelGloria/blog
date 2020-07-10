package com.example.demo;

import com.example.demo.controller.HelloWorldController;
import com.example.demo.controller.ItemController;

import com.example.demo.pojo.Item;
import com.example.demo.redis.IRedisService;
import javafx.application.Application;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

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

//    @Autowired
//    private LoginController loginController;
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

    @Autowired
    IRedisService iRedisService;

    @org.junit.Test
    public void RedisTest(){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();

        objectObjectHashMap.put("1","aa");

        System.out.println(objectObjectHashMap);
        System.out.println(System.currentTimeMillis()+"========"+String.valueOf(System.currentTimeMillis()));

//        iRedisService.setValue("1","gloria");
//
//        System.out.println(iRedisService.getValue("1"));

//        iRedisService.setValueString("testString","oo");
//
//        System.out.println(iRedisService.getValueString("testString"));
    }

    @org.junit.Test
    public void test2(){
        String str1 = "通话7";
        String str2 = "重地1";

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("1234567");

        stringBuffer.reverse();
        System.out.println(stringBuffer);
        boolean a = str1.contains("a");

        char c = str1.charAt(2);

        int i = str1.indexOf("1");

        byte[] bytes = str1.getBytes();
        System.out.println(a+"---"+c+"===="+i+"----"+bytes.toString()+"===="+bytes);
        System.out.println(String.format("str1: %d , str2: %d",str1.hashCode(),str2.hashCode()));
    }

    @org.junit.Test
    public void TestAboutFiles() throws IOException {

        Path path = Paths.get("D:\\ser.txt");

        File file = new File("D:\\ser.txt");

        /*
        * file转path
        * */
        Path path1 = file.toPath();

        /*
        * file转uri
        * */
        URI uri = file.toURI();

        /*
        * path转file
        * */
        path1.toFile();

        Path path2 = Paths.get(".");
        Path path3 = path2.toAbsolutePath();

        Path path4 = Paths.get(".\\demo.iml");

        System.out.println(path4.toAbsolutePath());
        System.out.println(path4.toAbsolutePath().normalize());
        System.out.println(path4.toRealPath());


        ArrayList<Object> objects = new ArrayList<>();

        objects.add("ab");
        objects.add("c");

        Object[] objects1 = objects.toArray();

        String[] strings = new String[10];

        Iterator<Object> iterator = objects.iterator();

        ListIterator<Object> objectListIterator = objects.listIterator();

//        objectListIterator.previous();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        Arrays.asList(strings);

        try {

        }finally {

        }

        try {

        }catch (Exception e){

        }

        /**
         *创建线程
         */

        ExecuteExtendThread executeExtendThread = new ExecuteExtendThread();

        executeExtendThread.start();

        ExecuteInterfaceRunnable executeInterfaceRunnable = new ExecuteInterfaceRunnable();

        Thread thread = new Thread(executeInterfaceRunnable);
        Thread thread2 = new Thread(executeInterfaceRunnable);

        ExecuteInterfaceCallable executeInterfaceCallable = new ExecuteInterfaceCallable();
        FutureTask<String> objectFuture = new FutureTask<String>(executeInterfaceCallable);
        Thread thread3 = new Thread(objectFuture);
//        objectFuture.s

        thread.start();
        thread2.start();

        thread3.setName("future");
        thread3.start();

        try {
            Object o = objectFuture.get();
            System.out.println(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        /**
         *实现一个动态代理
         */

        /**
         * 克隆
         */

        /**
         *sql 触发器
         */

        /**
         *回家需要准备的东西
         *
         * 一个ssm+spring的框架，注意一定要跑通，不然就废了！！！
         *
         * 算法(二分什么的……)
         *
         * 手写一个数据库连接？
         *
         * java基础再看看(什么基本数据类型字节字符，最好再写一下io)
         *
         * redis数据类型
         */

        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=gbk ;";
            String username = "";
            String pwd = "";
            Connection connection = DriverManager.getConnection(url,username,pwd);

            String sql = "";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String name = resultSet.getString("name");
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    class ExecuteExtendThread extends Thread{


    }

    class ExecuteInterfaceRunnable implements Runnable
    {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"--------");
        }
    }

    class ExecuteInterfaceCallable implements Callable {

        @Override
        public Object call() throws Exception {
            System.out.println(Thread.currentThread().getName()+"--------");
            return 22;
        }
    }




    @org.junit.Test
    public void tryCatchTest(){

        int i = tryCatch();
        System.out.println(i);
    }


    public int tryCatch(){
        int i = 1;
        try {
           System.out.println("first");
//            i = i/0;
            System.out.println("second");
            return i=2;
        }catch (Exception e){
            System.out.println("third");
            return i = 3;
        }finally {
            System.out.println("four");
             i = 4;
        }
    }

    @org.junit.Test
    public void timeTest(){

        Date date = new Date(System.currentTimeMillis());
        System.out.println(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println(format);
    }

}
