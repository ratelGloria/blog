package com.example.demo.aop;

import com.example.demo.common.ServerResponse;
import com.example.demo.pojo.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
@Aspect
public class LoginAspect {

    //先写切点，by the way，印象中我已经写过一次关于aspect的笔记了，但是但是但是，毫无印象……

//    @Autowired
//    HttpSession httpSession;

//    @Pointcut("execution (* com.example.demo.controller..*(..))")
    public void loginAspect(){}

//    @Before("loginAspect()")
    public void loginAspectBefore(JoinPoint joinPoint){

        System.out.println("------beforelogin------");
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = (HttpServletRequest)requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);

        String token = request.getHeader("token");
        System.out.println("------token------"+token);


        HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
        System.out.println("------token------"+session);
    }
//    @Around("loginAspect()")
    public void loginAspectAround(JoinPoint joinPoint){

        System.out.println("------Aroundlogin------");
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = (HttpServletRequest)requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);

        String userName = (String)request.getSession().getAttribute("userName");

//        String token = request.getHeader("token");


        if(userName == null){
            System.out.println("---Around---token------"+userName);
            User user = new User();
            user.setId(1);
            user.setUsername("hh");
//            return ServerResponse.serverResponseSuccess(user);
//            return user;
//            return ServerResponse.serverResponseUnSuccess("How are you");
        }else {
            System.out.println("---Around---token--22----"+userName);
//            return null;
//            return ServerResponse.serverResponseSuccess();
        }

//        HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
//        System.out.println("----Around--token------"+session);
    }
}
