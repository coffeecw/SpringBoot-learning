package cn.cwcoffee.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * created by coffeecw 2019/11/14
 */
//使用WebMvcConfigurerAdapter扩展SpringMVC的功能
//@EnableWebMvc  标注这个注解全面接管SpringMVC的自动配置，，所有都是我们自己配置；所有的SpringMVC的自动配置都失效了
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 浏览器发送 /cwcoffee 请求来到 success
        registry.addViewController("/cwcoffee").setViewName("success");
    }
}
