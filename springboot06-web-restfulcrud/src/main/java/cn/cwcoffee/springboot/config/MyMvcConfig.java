package cn.cwcoffee.springboot.config;

import cn.cwcoffee.springboot.component.LoginHandlerInterceptor;
import cn.cwcoffee.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author cw
 * @Date 2019/11/14
 */
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    /**
     * 使用WebMvcConfigurerAdapter扩展SpringMVC的功能
     * @EnableWebMvc  标注这个注解全面接管SpringMVC的自动配置，，所有都是我们自己配置；所有的SpringMVC的自动配置都失效了
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 浏览器发送 /cwcoffee 请求来到 success
        registry.addViewController("/cwcoffee").setViewName("success");
    }

    /**
     * 所有的WebMvcConfigurerAdapter组件会一起起作用,将组件注册在容器中
     * @return
     */
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                //请求路径添加视图解析,登录成功实现重定向
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            /**
             * 添加拦截器
             * @param registry
             */
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //静态资源: *.css,*.js路径:/asserts/**,/webjars/**,也需要排除掉
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login.html","/","/user/login","/asserts/**","/webjars/**");
            }
        };
        return adapter;
    }

    /**
     * 国际化注入
     * @return
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

}
