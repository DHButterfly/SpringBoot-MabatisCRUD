package com.dl.controller;

import com.dl.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 *自定义异常处理&返回定制json数据；
 */

@ControllerAdvice
public class MyExceptionHandler {
    //这种方法浏览器和其他客户端(adrioid等)返回的都是json数据，没有自适应效果
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String,Object> handlerException(Exception ex){
//        Map<String,Object>maps=new HashMap<>();
//        maps.put("code","user.notexist");
//        maps.put("message",ex.getMessage());
//        return maps;//利用responsebody返回响应json数据
//    }
    @ExceptionHandler(UserNotExistException.class)//要处理的异常类
    public String handlerException(Exception ex, HttpServletRequest request){
        Map<String,Object>maps=new HashMap<>();
        //传入自己的状态码
        request.setAttribute("javax.servlet.error.status_code",500);
        maps.put("code","user not exist!!!");
        maps.put("message",ex.getMessage());
        request.setAttribute("ext",maps);
        return "forward:/error";//转发到/error请求，basicerrorcontroller会进行自适应处理,但是默认状态码是200
    }
}
