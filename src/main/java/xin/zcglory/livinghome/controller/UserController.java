package xin.zcglory.livinghome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import xin.zcglory.livinghome.util.MyStringUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@RequestMapping("/user")
@Controller
public class UserController {

    @PostMapping("/login")
    public String login(String userName, String password, Map map, HttpServletRequest request) {
        if (MyStringUtil.checkStringIsNull(userName, password)) {
            if (userName.equals("zc") && password.equals("666")) {
                request.getSession().setAttribute("userName", userName);
            } else {
                map.put("message", "请输入正确的账号或密码");
                return "login";
            }
        } else {
            map.put("message", "账号或密码不能为空");
            return "login";
        }
        return "home";

    }

}
