package cn.cwcoffee.springboot.controller;

import cn.cwcoffee.springboot.entity.User;
import cn.cwcoffee.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author coffeecw
 * @Date 2019/12/10 22:30
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id){
        User user = userRepository.findOne(id);
        return user;
    }

    @GetMapping("/user")
    public User addUser(User user){
        User save = userRepository.save(user);
        return save;
    }
}
