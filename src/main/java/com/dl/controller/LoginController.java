package com.dl.controller;

import com.dl.service.impl.CheckLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Administrator on 2020/5/9.
 */
@Controller
public class LoginController {
    @Autowired
    private CheckLoginServiceImpl loginService;
    //@PostMapping("/user/login")
    @RequestMapping(value = "/user/login",method= RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session, Map<String,Object>maps){
        if(StringUtils.isEmpty(username)||StringUtils.isEmpty(password)){
            maps.put("msg","用户名和密码都不能为空");
            return "login";
        }
        //需要根据用户名验证密码
        String pwd=loginService.getPassword(username);
        //调用ServiceImpl获取该用户密码
        if(pwd.equals(password)){
            //防止表单重复提交，采用重定向的方式
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else{
            maps.put("msg","用户名或密码错误");
            return "login";
        }
    }
}
