package cn.cwcoffee.springboot.mapper;

import cn.cwcoffee.springboot.bean.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author cw
 * @Date 2019/12/14 22:56
 */
@Mapper
public interface DepartmentMapper {
    @Select("select * from department where id = #{id}")
    Department getDeptById(Integer id);
}
