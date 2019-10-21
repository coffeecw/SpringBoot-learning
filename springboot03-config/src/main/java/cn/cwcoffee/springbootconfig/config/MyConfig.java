package cn.cwcoffee.springbootconfig.config;

import cn.cwcoffee.springbootconfig.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * created by coffeecw 2019/10/21
 * @Configuration  指明当前类是一个配置类，就是用来替代之前的Spring配置文件
 * 在配置文件中<bean></bean>标签添加组件
 */
@Configuration
public class MyConfig {
    //将方法的返回值添加到容器中，容器中这个组件默认的id就是方法名
    @Bean
    public HelloService helloService02(){
        System.out.println("给容器添加组件");
        return new HelloService();
    }
}
