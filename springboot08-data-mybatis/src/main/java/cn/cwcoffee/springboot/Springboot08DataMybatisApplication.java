package cn.cwcoffee.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//扫描包的形式扫描mapper接口
@MapperScan(basePackages = "cn.cwcoffee.springboot.mapper")
@SpringBootApplication
public class Springboot08DataMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot08DataMybatisApplication.class, args);
    }

}
