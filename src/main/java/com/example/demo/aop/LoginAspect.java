package com.example.demo.aop;

import com.example.demo.common.ServerResponse;
import com.example.demo.pojo.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@Component
@Aspect

public class LoginAspect {

    //先写切点，by the way，印象中我已经写过一次关于aspect的笔记了，但是但是但是，毫无印象……

//    @Autowired
//    HttpSession httpSession;

    @Pointcut("execution (* com.example.demo.controller..*(..))")
    public void loginAspect(){}

    @Before("loginAspect()")
    public void loginAspectBefore(JoinPoint joinPoint){

        System.out.println("------beforelogin------");
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();

        ServletRequestAttributes requestAttributes1 = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();

        HttpSession session1 = requestAttributes1.getRequest().getSession();

        String sessionId = session1.getId();
        User user = (User)session1.getAttribute("user");
        if(user == null){
            //这个地方就该返回点什么了
            User user1 = new User();
            user1.setToken(sessionId);
            session1.setAttribute("user",sessionId);
            System.out.println(sessionId+"--重新set了一个user------------");
        }
        String sessionId2 = (String)session1.getAttribute("user");
        System.out.println("--session1------"+sessionId2);

        /*
        * 我只能说，更多选择，更多欢乐
        * */
//        HttpServletRequest request = (HttpServletRequest)requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
//        HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
//        System.out.println("------token------"+session);

    }


//    @Around("loginAspect()")
    public void loginAspectAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("------Aroundlogin------");
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = (HttpServletRequest)requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);

        String userName = (String)request.getSession().getAttribute("userName");

//        String token = request.getHeader("token");
        System.out.println("---Around---token------"+userName);

        if(userName == null){
//            return ServerResponse.serverResponseUnSuccess("How are you");
        }else {

            proceedingJoinPoint.proceed();

        }


//        HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
//        System.out.println("----Around--token------"+session);
    }
}
