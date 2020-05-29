package com.dl.controller;

import com.dl.service.impl.CheckRegisterImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;
@Controller
@RequestMapping(value="/user")
public class RegisterController {
    @Autowired
    private CheckRegisterImpl registerService;
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@RequestParam("username")String username,
                           @RequestParam("password")String password,
                           @RequestParam("passwordAgain")String passwordAgain,
                           HttpSession session, Map<String,Object> maps){
        System.out.println(username+"---"+password+"---"+passwordAgain);
        if(StringUtils.isEmpty(username)){
            maps.put("reg","用户名不能为空!");
            return "register";
        }else if(StringUtils.isEmpty(password)||StringUtils.isEmpty(passwordAgain)){
            maps.put("reg","密码不能为空!!!");
            return "register";
        }else if(!password.equals(passwordAgain)){
            maps.put("reg","两次密码不一致!!!");
            return "register";
        }else if(password.length()<4||password.length()>16){
            maps.put("reg","密码长度为4-16位");
            return "register";
        }else if(registerService.CheckRegister(username)!=null){
            maps.put("reg","用户名已注册");
            return "register";
        }
        registerService.RegisterUser(username,password);
        //调用业务层完成注册功能
        return "login";
    }
}
