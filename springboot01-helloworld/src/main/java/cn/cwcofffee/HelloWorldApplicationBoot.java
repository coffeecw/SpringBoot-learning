package cn.cwcofffee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * created by coffeecw 2019/10/14
 */
@SpringBootApplication//标注一个主程序类，说明这是一个Spring Boot应用
public class HelloWorldApplicationBoot {
    public static void main(String[] args) {
        //Spring Boot应用启动起来
        SpringApplication.run(HelloWorldApplicationBoot.class, args);
    }
}
