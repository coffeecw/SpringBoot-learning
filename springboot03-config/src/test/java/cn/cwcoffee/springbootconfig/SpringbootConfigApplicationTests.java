package cn.cwcoffee.springbootconfig;

import cn.cwcoffee.springbootconfig.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SpringBoot单元测试
 * 可以在测试期间很方便的类似编码一样自动注入容器的功能
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootConfigApplicationTests {
    @Autowired
    private Person person;

    @Autowired
    ApplicationContext ioc;
    @Test
    public void contextLoads() {
        System.out.println(person);
    }

    @Test
    public void test(){
        boolean helloService = ioc.containsBean("helloService");
        System.out.println(helloService);
    }

}
