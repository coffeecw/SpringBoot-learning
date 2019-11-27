package cn.cwcoffee.springboot.controller;

import cn.cwcoffee.springboot.dao.DepartmentDao;
import cn.cwcoffee.springboot.dao.EmployeeDao;
import cn.cwcoffee.springboot.entities.Department;
import cn.cwcoffee.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

/**
 * @Author cw
 * @Date 2019/11/26 16:13
 */
@Controller
public class EmpController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;
    /**
     * 查询所有员工
     * @return
     */
    @GetMapping("/emps")
    public String getEmps(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps",employees);
        //thymeleaf自动会拼串
        //classpath:/templates/xxx.html
        return "emp/list";
    }

    /**
     * 来到添加页面
     * @return
     */
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //先查询出部门信息，添加到页面中
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    /**
     * 员工添加
     * SpringMVC自动将请求参数和入参对象属性进行一一绑定,要求请求参数的名字和javabean入参的对象里面的属性名是一样的
     * @param employee
     * @return
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //来到员工列表页面
        System.out.println("保存的员工信息:"+employee);
        //保存员工信息
        employeeDao.save(employee);
        //redirect  表示重定向到一个地址  /代表当前项目路径
        //forward    表示转发到一个地址
        return "redirect:/emps";
    }
}
