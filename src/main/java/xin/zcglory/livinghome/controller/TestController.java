package xin.zcglory.livinghome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import xin.zcglory.livinghome.exception.ExceptionTest;

@Controller
public class TestController {

    @RequestMapping("error_500")
    public void error_500() {
        throw new ExceptionTest();
    }
}
