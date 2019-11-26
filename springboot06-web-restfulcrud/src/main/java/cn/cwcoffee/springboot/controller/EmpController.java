package cn.cwcoffee.springboot.controller;

import cn.cwcoffee.springboot.dao.EmployeeDao;
import cn.cwcoffee.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * @Author cw
 * @Date 2019/11/26 16:13
 */
@Controller
public class EmpController {

    @Autowired
    private EmployeeDao employeeDao;
    /**
     * 查询所有员工
     * @return
     */
    @RequestMapping("/emps")
    public String getEmps(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps",employees);
        //thymeleaf自动会拼串
        //classpath:/templates/xxx.html
        return "emp/list";
    }
}
