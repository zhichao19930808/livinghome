package xin.zcglory.livinghome.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import xin.zcglory.livinghome.exception.ExceptionTest;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义异常类
 */
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(ExceptionTest.class)
    public String handlerException(Exception e, HttpServletRequest requeest) {

        Map<String, String> map = new HashMap<String, String>();
        //传入自己的错误状态码
        requeest.setAttribute("javax.servlet.error.status_code",500);
        map.put("message", "自定义异常");
        map.put("code", "TestError");
        requeest.setAttribute("company_message",map);
        return "forward/error";
    }
}
