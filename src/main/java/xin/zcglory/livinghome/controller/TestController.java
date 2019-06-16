package xin.zcglory.livinghome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("error_500")
    public void error_500() {
        throw new RuntimeException("500练习");
    }
}
