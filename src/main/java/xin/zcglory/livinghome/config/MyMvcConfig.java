package xin.zcglory.livinghome.config;

import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import xin.zcglory.livinghome.component.MyLocalResolver;
import xin.zcglory.livinghome.component.MyLoginHandlerInterceptor;

/**
 * 自定义一个mvc解析器，作用是在spring Boot自身解析器的基础上进行一些扩充
 * 备注@EnableWebMvc 该备注会使springMVC的所有的配置都失效，正常不需要添加
 *
 */
//@EnableWebMvc
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {


    @Bean//将组件注册在spring容器中
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer(){
            /**
             * 添加视图解析
             */
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("index");
                registry.addViewController("/index.html").setViewName("index");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/home.html").setViewName("home");
            }
            /**
             * 注册拦截器
             */
            //将组件注册在spring容器中
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //静态资源；  *.css , *.js
                //SpringBoot已经做好了静态资源映射
                registry.addInterceptor(new MyLoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html","/login.html","/","/user/login");

            }
        };
    }

    /**
     * 添加自定义的国际化视图
     * @return 自定义的国际化视图
     */
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocalResolver();
    }


}
