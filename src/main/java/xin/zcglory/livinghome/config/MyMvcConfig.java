package xin.zcglory.livinghome.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 自定义一个mvc解析器，作用是在spring Boot自身解析器的基础上进行一些扩充
 * 备注@EnableWebMvc 该备注会使springMVC的所有的配置都失效，正常不需要添加
 */
//@EnableWebMvc
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
/*
 * 添加视图解析有两种方法
 */
    /**
     * 1，手动添加一个视图解析
     *
     * @param registry 视图解析
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //在此处设置
//        registry.addViewController("/").setViewName("index");

    }

    /**
     * 2，所有的WebMvcConfigurer组件会一起起作用
     * @return 视图解析
     */
    @Bean//将组件注册在spring容器中
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("index");
                registry.addViewController("/index.html").setViewName("index");
            }
        };
    }
}
