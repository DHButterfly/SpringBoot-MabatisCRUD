package com.dl.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 配置监听器
 */
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Web 应用启动了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Web 应用销毁了");
    }
}
