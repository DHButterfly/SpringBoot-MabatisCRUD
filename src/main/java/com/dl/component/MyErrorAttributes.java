package com.dl.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * 页面上能用的数据，或者是json返回能用的数据都是通过errorAttributes.getErrorAttributes得到；
 * 容器中DefaultErrorAttributes.getErrorAttributes()；默认进行数据处理的；
 *
 * 出现错误以后，会来到/error请求，会被BasicErrorController处理，
 * 响应出去可以获取的数据是由getErrorAttributes得到的
 *
 * 最终的效果：响应是自适应的，可以通过定制ErrorAttributes改变需要返回的内容，
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> maps = super.getErrorAttributes(webRequest, includeStackTrace);
        Throwable error=getError(webRequest);
        if(error!=null) maps.put("exception",error.getClass().getName());
        Map<String,Object> ext = (Map<String, Object>) webRequest.getAttribute("ext", 0);
        maps.put("ext",ext);
        maps.put("company","dl");
        return maps;
    }

}
