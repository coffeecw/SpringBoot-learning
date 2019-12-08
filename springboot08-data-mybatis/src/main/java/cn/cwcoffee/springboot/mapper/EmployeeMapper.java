package cn.cwcoffee.springboot.mapper;

import cn.cwcoffee.springboot.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author coffeecw
 * @Date 2019/12/8 22:09
 */
//需要用Mapper或者MapperScan注解装配到容器中
public interface EmployeeMapper {

    Employee getEmployee(Integer id);

    int insertEmployee(Employee employee);
}
