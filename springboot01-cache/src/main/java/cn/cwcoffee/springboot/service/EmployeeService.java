package cn.cwcoffee.springboot.service;

import cn.cwcoffee.springboot.bean.Employee;
import cn.cwcoffee.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;




/**
 * @Author cw
 * @Date 2019/12/14 23:45
 */
//抽取缓存的公共配置
@CacheConfig(cacheNames = "emp",cacheManager = "empRedisCacheManager")

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 注意缓存加在service层,且要指定缓存名
     *
     * 将方法的运行结果进行缓存,以后再要相同的数据，直接从缓存中取，不用调用方法
     *
     * CacheManager管理多个Cache组件的，对缓存的CRUD操作在Cache组件中，每一个缓存组价都有自己唯一一个名字
     * 注解中几个属性：
     *          cacheName/value：指定缓存组件的名字,将方法的返回结果放在哪个缓存中，是数组的方式，可以指定多个缓存
     *          key:缓存数据使用的key;可以用它来指定。默认是使用方法参数的值
     *              编写SpEL,#id;参数id的值  #a0 #p0 #root.args[0]
     *          keyGenerator:key的生成器，可以自己指定key的生成器的组件的id
     *              key/keyGenerator:二选一使用
     *          CacheManager:指定缓存管理器,或者指定CacheResolver指定获取解析器
     *          condition：指定符合条件的情况下才缓存
     *          unless：否定缓存，当unless指定的条件为true，方法的返回值就不会被缓存，可以获取到结果进行判断
     *              unless="#result==null"
     *          sync:是否使用异步模式
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "emp")
    public Employee getEmp(Integer id){
        System.out.println("查询"+id+"号员工");
        Employee emp = employeeMapper.getEmp(id);
        return emp;
    }

    /**
     * 既调用方法,又更新缓存数据,同步缓存数据
     * 修改了数据库某个数据,同时更新缓存
     * @param employee
     * @return
     */
    @CachePut(/*cacheNames = "emp",*/key = "#employee.id")
    public Employee updateEmp(Employee employee){
        System.out.println("update:"+employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }

    /**
     * 缓存清除
     * key:指定要清除的数据
     * allEntries = true 指定清除这个缓存中所有的数据
     * beforeInvocation = false 缓存的清除是否在方法之前执行
     *      默认代表缓存清除操作是在方法之后执行,如果出现异常就不会清除缓存
     * beforeInvocation = true
     *      代表缓存清除操作是在方法之前执行，无论方法是否出现异常,缓存都清除
     * @param id
     */
    @CacheEvict(/*cacheNames = "emp",*/beforeInvocation = true/*key = "#id"*/)
    public void deleteEmp(Integer id){
        System.out.println("delEmp:"+id);
//        employeeMapper.deleteEmp(id);
        int i = 10/0;
    }
    //定义复杂的缓存规则
    //注意当key为null时会报错
    @Caching(
            cacheable = {
                    @Cacheable(value = "emp",key = "#lastName")
            },
            put = {
                    @CachePut(value = "emp",key = "#result.id"),
                    @CachePut(value = "emp",key = "#result.gender")
            }
    )
    public Employee getEmpByLastName(String lastName) {
        return employeeMapper.getEmpByLastName(lastName);
    }
}
