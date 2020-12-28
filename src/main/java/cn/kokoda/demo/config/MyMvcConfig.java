package cn.kokoda.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Autowired
    private LoginHandlerInterceptor loginHandlerInterceptor;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/reg").setViewName("register");
        registry.addViewController("/main").setViewName("dashboard");
//        registry.addViewController("/table").setViewName("table");
        registry.addViewController("/reward").setViewName("reward");
        registry.addViewController("/attendance").setViewName("attendance");
        registry.addViewController("/department").setViewName("department");
        registry.addViewController("/404").setViewName("error/404");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginHandlerInterceptor).addPathPatterns("/**").excludePathPatterns("/", "/reg", "/user/*", "/css/**", "/js/**", "/img/**");
    }
}
