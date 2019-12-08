package cn.cwcoffee.springboot.controller;

import cn.cwcoffee.springboot.bean.Department;
import cn.cwcoffee.springboot.bean.Employee;
import cn.cwcoffee.springboot.mapper.DepartmentMapper;
import cn.cwcoffee.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author coffeecw
 * @Date 2019/12/8 21:27
 */
//返回JSON数据
@RestController
public class DeptController {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id){
        return departmentMapper.getDeptById(id);
    }

    @GetMapping("/dept")
    public Department insertDepartment(Department department){
        departmentMapper.insertDept(department);
        return department;
    }

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){
        return employeeMapper.getEmployee(id);
    }
}
