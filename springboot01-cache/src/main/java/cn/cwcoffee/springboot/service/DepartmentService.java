package cn.cwcoffee.springboot.service;

import cn.cwcoffee.springboot.bean.Department;
import cn.cwcoffee.springboot.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Author cw
 * @Date 2019/12/22 13:31
 */
/*@CacheConfig(cacheManager = "deptRedisCacheManager")*/
@Service
public class DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Qualifier("deptRedisCacheManager")
    @Autowired
    private CacheManager deptRedisCacheManager;

    /**
     * 缓存的数据能存入Redis;
     * 第二次从缓存中查询就不能反序列化回来；
     * 存的是dept的json数据;CacheManager默认使用RedisTemplate<Object,Employee>操作redis
     * @param id
     * @return
     */
//    @Cacheable(cacheNames = "dept",cacheManager = "deptRedisCacheManager")
//    public Department getDeptById(Integer id){
//        System.out.println("查询部门"+id);
//        return departmentMapper.getDeptById(id);
//    }

    /**
     * 编码的方式操作缓存
     * 使用缓存管理器得到缓存，进行api调用
     * @param id
     * @return
     */
    public Department getDeptById(Integer id){
        System.out.println("查询部门"+id);
        Department dept = departmentMapper.getDeptById(id);
        Cache cache = deptRedisCacheManager.getCache("dept");
        cache.put("1",dept);
        return dept;
    }
}
