package com.dl.component;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 点击链接切换国际化：LocaleResolver（获取区域信息对象）
 * 国际化切换配置,可在链接上携带区域信息,默认的就是根据请求头带来的区域信息获取Locale进行国际化
 *
 */
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l=request.getParameter("l");//形如en_US、zh_CN(语言_国家)
        Locale locale= Locale.getDefault();
        if(!StringUtils.isEmpty(l)){
            String split[]=l.split("_");
            locale=new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
