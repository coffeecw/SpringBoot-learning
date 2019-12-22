package cn.cwcoffee.springboot.controller;

import cn.cwcoffee.springboot.bean.Department;
import cn.cwcoffee.springboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author cw
 * @Date 2019/12/22 13:35
 */
@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/dept/{id}")
    public Department getDeptById(@PathVariable("id") Integer id){
        return departmentService.getDeptById(id);
    }

}
