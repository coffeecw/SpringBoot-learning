package cn.cwcoffee.springboot;

import cn.cwcoffee.springboot.bean.Employee;
import cn.cwcoffee.springboot.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Springboot01CacheApplicationTests {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void contextLoads() {
        Employee emp = employeeMapper.getEmp(1);
        System.out.println(emp);
    }

}
