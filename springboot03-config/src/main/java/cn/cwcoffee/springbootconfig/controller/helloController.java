package cn.cwcoffee.springbootconfig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by coffeecw 2019/10/21
 */
@RestController
public class helloController {
    @Value("${person.last-name}")
    private String name;
    @RequestMapping("/hello")
    public String sayHello(){
        return "hello "+name;
    }
}
