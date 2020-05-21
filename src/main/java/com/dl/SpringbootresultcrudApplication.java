package com.dl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * 国际化步骤：
 * 1、编写国际化配置文件，抽取页面需要显示的国际化消息i18n
 * 2、使用ResourceBundleMessageSource管理国际化资源文件(SpringBoot自动配置好了)
 * 3、在页面使用fmt:message取出国际化内容
 * WebJars能使Maven的依赖管理支持OSS的JavaScript库/CSS库，比如jQuery、Bootstrap等；
 *WebJars是将Web前端Javascript和CSS等资源打包成Java的Jar包，这样在Java Web开发中我们
 * 可以借助Maven这些依赖库的管理，保证这些Web资源版本唯一性。
 * 使用需要引入js库和bootstrap依赖
 */
@SpringBootApplication
@MapperScan(value = "com.dl.mapper")
public class SpringbootresultcrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootresultcrudApplication.class, args);
	}

	/**
	 * 自定义视图解析器，然后将其加入到容器中，通过前端控制器dispatcherservlet中
	 * 的dodispatch打断点以debug方式查看,找到自己的即成功了,主要是验证springboot自动组合所有的视图解析器
	 * @return
	 */
	@Bean
	public ViewResolver MyViewResolver(){
		return new MyviewResolver();
	}
	public static class MyviewResolver implements ViewResolver{

		@Override
		public View resolveViewName(String s, Locale locale) throws Exception {
			return null;
		}
	}
}
