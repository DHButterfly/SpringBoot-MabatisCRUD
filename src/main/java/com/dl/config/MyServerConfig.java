package com.dl.config;

import com.dl.filter.MyFilter;
import com.dl.listener.MyListener;
import com.dl.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.Arrays;
import java.util.EventListener;

/**
 * Created by Administrator on 2020/5/13.
 */
@Configuration
public class MyServerConfig  {
    //自定义的Servlet(com.dl.servlet)注册三大组件
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean registrationBean=new ServletRegistrationBean(new MyServlet(),"/MyServlet");
        return registrationBean;
    }
    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new MyFilter());
        filterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/MyServlet"));//配置servlet映射
        return filterFilterRegistrationBean;
    }
    @Bean
    public ServletListenerRegistrationBean listenerRegistrationBean(){
        ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean<MyListener>(new MyListener());
        return registrationBean;
    }
}
