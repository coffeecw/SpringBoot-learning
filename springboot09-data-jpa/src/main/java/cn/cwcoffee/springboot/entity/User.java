package cn.cwcoffee.springboot.entity;

import javax.persistence.*;

/**
 * @Author coffeecw
 * @Date 2019/12/10 22:12
 * 使用JPA注解配置因映射关系
 */
//和数据表映射的类
//告诉JPA这是一个实体类（和数据表映射的类）
@Entity
//@Table来指定和哪个数据表对应;如果省略默认表名就是user
@Table(name = "tbl_user")
public class User {
    //这是一个主键
    @Id
    //自增主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //这是和数据表对应的一个列
    @Column(name = "last_name",length = 50)
    private String lastName;

    //省略默认列名就是属性名
    @Column
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
