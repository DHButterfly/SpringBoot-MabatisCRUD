package com.dl.controller;

import com.dl.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by Administrator on 2020/5/7.
 * "/**"表示访问当前项目的任何资源(静态资源文件夹)
 * classpath:/META-INF/resources/
 * classpath:/resources/
 * classpath:/static/
 * classpath:/public/
 * classpath:后面的/表示当前项目的根路径
 * 只要我们将html放在classpath:/templates/下，thymeleaf就能自动渲染
 */
//所有的**/favicon都去静态资源文件夹下找，访问localhost:8080/则是去静态资源文件夹下诏index.html(被/**映射)
@Controller
public class HelloController {
//    @RequestMapping({"/","/index.html"})
//    public String index(){
//        return "login";
//    }
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user){
        if(user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "Hello SpringBoot";
    }
    @RequestMapping("/success")
    public String success(Map<String,Object>maps){
        //classpath:/templates/success.html
        maps.put("hello","<h2>hello thymeleaf!</h2>");
        maps.put("replace","使用th:任意属性替换原生的html属性值");
        maps.put("users", Arrays.asList("张三","李四","王五"));
        return "success";
    }
}
