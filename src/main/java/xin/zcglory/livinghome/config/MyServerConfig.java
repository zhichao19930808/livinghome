package xin.zcglory.livinghome.config;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xin.zcglory.livinghome.filter.MyFilter;
import xin.zcglory.livinghome.listener.MyListener;
import xin.zcglory.livinghome.servlet.MyServlet;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * server相关（服务起相关的配置类）
 *
 */
@Configuration
public class MyServerConfig {

//注册三大组件----------------------------------------------------------------------------------------------------------

    /**
     * 注册servlet
     * @return servletRegistrationBean
     */
    @Bean
    public ServletRegistrationBean myServlet() {
        ServletRegistrationBean<Servlet> servletRegistrationBean = new ServletRegistrationBean<>(new MyServlet(),"/myServlet");
        return servletRegistrationBean;
    }

    /**
     * 注册Filter
     * @return filterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/myServlet","/error_500"));
        return filterRegistrationBean;
    }


    /**
     * 注册Listener
     * @return ServletListenerRegistrationBean
     */
    @Bean
    public ServletListenerRegistrationBean regServletListener() {
        ServletListenerRegistrationBean<MyListener> loginSessionListener= new ServletListenerRegistrationBean<MyListener>();
        loginSessionListener.setListener(new MyListener());
        return loginSessionListener;

    }
//配置嵌入式的servlet容器------------------------------------------------------------------------------------------------
    /**
     * 配置嵌入式的servlet容器
     * @return WebServerFactoryCustomizer 后续补备注
     */
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryWebServerFactoryCustomizer() {
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            /**
             * 定制嵌入式servlet容器相关的规则
             * @param factory 嵌入式的servlet容器
             */
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                factory.setPort(8086);
            }
        };
    }
//配置嵌入式的servlet容器------------------------------------------------------------------------------------------------

}
