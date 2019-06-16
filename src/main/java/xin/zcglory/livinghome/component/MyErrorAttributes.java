package xin.zcglory.livinghome.component;


import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;


/**
 * 给spring容器中加入自定义的errorAttributes
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes{
    //考虑是再原有的基础上添加新内容，所以直接继承父类。

    /**
     * 重写父类的getErrorAttributes()方法
     * @param webRequest 该类包装了request
     * @param includeStackTrace
     * @return ErrorAttributes
     */
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        //使用父类的getErrorAttributes()方法，获取springBoot错误处理的默认行为。
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        //在默认的基础上，添加自定义的内容
        map.put("company", "活人先生的小屋");
        map.put("company_message", webRequest.getAttribute("company_message", 0));
        return map;


    }
}
