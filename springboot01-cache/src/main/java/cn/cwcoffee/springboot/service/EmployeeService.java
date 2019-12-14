package cn.cwcoffee.springboot.service;

import cn.cwcoffee.springboot.bean.Employee;
import cn.cwcoffee.springboot.mapper.EmployeeMapper;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author cw
 * @Date 2019/12/14 23:45
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    public Employee getEmp(Integer id){
        System.out.println("查询"+id+"号员工");
        Employee emp = employeeMapper.getEmp(id);
        return emp;
    }

}
