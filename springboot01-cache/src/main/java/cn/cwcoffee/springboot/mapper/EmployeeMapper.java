package cn.cwcoffee.springboot.mapper;

import cn.cwcoffee.springboot.bean.Employee;
import org.apache.ibatis.annotations.*;

/**
 * @Author cw
 * @Date 2019/12/14 22:56
 */
@Mapper
public interface EmployeeMapper {
    @Select("SELECT * FROM employee WHERE id = #{id}")
    Employee getEmp(Integer id);

    @Update("UPDATE employee set lastName = #{lastName},email = #{email},gender = #{gender},d_id = #{dId} WHERE id = #{id}")
    int updateEmp(Employee employee);

    @Delete("DELETE FROM employee WHERE id = #{id}")
    int deleteEmp(Integer id);

    @Insert("INSERT INTO employee(lastName,email,gender,d_id) VALUES(#{lastName},#{email},#{gender},#{dId}) ")
    int insertEmp(Employee employee);

    @Select("SELECT * FROM employee WHERE lastName = #{lastName}")
    Employee getEmpByLastName(String lastName);
}
