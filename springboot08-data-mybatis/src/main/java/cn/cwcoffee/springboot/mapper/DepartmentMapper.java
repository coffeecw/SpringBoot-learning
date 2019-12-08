package cn.cwcoffee.springboot.mapper;

import cn.cwcoffee.springboot.bean.Department;
import org.apache.ibatis.annotations.*;

/**
 * @Author coffeecw
 * @Date 2019/12/8 21:15
 */
//指定这是一个操作数据库的mapper
//@Mapper
public interface DepartmentMapper {
    @Select("select * from department where id = #{id}")
    Department getDeptById(Integer id);

    @Delete("delete from department where id = #{id}")
    int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(departmentName) values(#{departmentName})")
    int insertDept(Department department);

    @Update("update department set departmentName=#{departmentName} where id = #{id}")
    int updateDept(Department department);
}
