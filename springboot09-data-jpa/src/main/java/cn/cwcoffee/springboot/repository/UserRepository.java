package cn.cwcoffee.springboot.repository;

import cn.cwcoffee.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author coffeecw
 * @Date 2019/12/10 22:20
 * 继承JpaRepository来完成对数据库的操作(包括基本的增删查改和分页)
 */
public interface UserRepository extends JpaRepository<User,Integer> {

}
