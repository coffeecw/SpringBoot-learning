package cn.cwcoffee.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author cw
 * @Date 2019/11/09
 */
@Controller
public class HelloController {

//    @RequestMapping({"/","/login.html"})
////    public String index(){
////        return "login";
////    }


    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello world";
    }


    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        //classpath:/templates/success.html
        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("lisi","wangwu","zhangsan"));
        return "success";
    }

}
