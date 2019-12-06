package cn.cwcoffee.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @Author coffeecw
 * @Date 2019/12/4 23:04
 */
@Controller
public class HelloController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/hello")
    @ResponseBody
    public List<Map<String, Object>> hello(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from department");
        return list;
    }
}
