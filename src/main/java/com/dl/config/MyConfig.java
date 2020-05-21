package com.dl.config;

import com.dl.component.LoginHandlerIntercepter;
import com.dl.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

/**
 * Created by Administrator on 2020/5/7.
 * 使用WebMvcConfigurer扩展springmvc'的功能
 */
//@EnableWebMvc 此注解标注在配置类上表示全面接管springmvc，springboot对springmvc的web自动配置将全部失效
//静态资源、webjars等的映射配置将失效，也就不能直接访问,springmvc所有东西都需要我们自己配置
@Configuration
public class MyConfig implements WebMvcConfigurer {
    /**
     * 若通过继承WebMvcConfigurationSupport 而静态文件不显示CSS样式的，
     * 这是因为替换之后之前的静态资源文件 会被拦截，WebMvcAutoConfiguration失效，而全面接管springmvc
     * 重写方法addResourceHandlers加上静态资源
     * @param registry
     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
//    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/dl").setViewName("success");
    }

    /**
     * 配置初始访问页面为login.html页面
     * 所有的WebMvcConfigurer都一起起作用
     * @return
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer adapter=new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                //添加视图映射
                //将/请求映射到login.html，视图解析器会自动加上后缀.html,详细查看ViewControllerRegistry
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");//
                registry.addViewController("/main.html").setViewName("dashboard");//
            }
        };
        return adapter;
    }

    /**
     * 将国际化切换信息注册到容器中
     * @return
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    /**
     * 配置拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //  "/**"拦截任意多层路径下的请求,excludePathPatterns排除拦截资源路径
        registry.addInterceptor(new LoginHandlerIntercepter()).addPathPatterns("/**")
                .excludePathPatterns("/index.html","/","/user/login","/webjars/**","/asserts/**");
    }
}
