package cn.cwcoffee.springboot.controller;

import cn.cwcoffee.springboot.bean.Employee;
import cn.cwcoffee.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author cw
 * @Date 2019/12/14 23:51
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){
        Employee emp = employeeService.getEmp(id);
        return emp;
    }
}
