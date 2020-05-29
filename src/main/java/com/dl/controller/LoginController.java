package com.dl.controller;

import com.dl.service.CheckRegisterService;
import com.dl.service.impl.CheckLoginServiceImpl;
import com.dl.service.impl.CheckRegisterImpl;
import com.dl.utils.VerifyCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/**
 * Created by Administrator on 2020/5/9.
 */
@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private CheckLoginServiceImpl loginService;

    //@PostMapping("/user/login")
    @RequestMapping(value = "/login",method= RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("verifyCode") String verifyCode,
                        HttpSession session, Map<String,Object>maps){
        String userVerifyCode=((String) session.getAttribute("verifyCode")).toLowerCase();
        verifyCode=verifyCode.toLowerCase();
        if(StringUtils.isEmpty(username)){
            maps.put("msg","用户名不能为空!!!");
            return "login";
        }else if(StringUtils.isEmpty(password)){
            maps.put("msg","密码不能为空!!!");
            return "login";
        }else if(StringUtils.isEmpty(verifyCode)){
            maps.put("msg","验证码不能为空!!!");
            return "login";
        }else if(!verifyCode.equals(userVerifyCode)){
            maps.put("msg","验证码错误!!!");
            return "login";
        }
        //需要根据用户名验证密码
        String pwd=loginService.getPassword(username);
        //调用ServiceImpl获取该用户密码
        if(pwd.equals(password)){
            //防止表单重复提交，采用重定向的方式
            session.setAttribute("loginUser",username);
            session.setMaxInactiveInterval(360);//设置session有效期为6分钟
            return "redirect:/main.html";
        }else{
            maps.put("msg","用户名或密码错误");
            return "login";
        }
    }

    /**
     * 生成图片验证码
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value ="/verifyCode")
    public void indentycode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        VerifyCodeUtil.setHeight(37);
        VerifyCodeUtil.setWidth(83);
        VerifyCodeUtil.setSize(10);
        VerifyCodeUtil.setDsize(10);
        //设置响应头
        response.setHeader("Pragma", "no-cache");
        //设置响应头
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("image/jpg");//必须设置响应内容类型为图片，否则前台不识别
        String indentycode = VerifyCodeUtil.generateVerifyCode();//生成图片验证码
        request.getSession().setAttribute("verifyCode", indentycode);//存入session作用域中
        BufferedImage image = VerifyCodeUtil.getBufferedImage(indentycode);
        //响应图片
        OutputStream os = response.getOutputStream(); //获取文件输出流
        ImageIO.write(image, "jpg", os);
        os.flush();
        os.close();
    }
    @RequestMapping("/out")
    public String UserOut(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.invalidate();//销毁session
        return "login";
    }
}
