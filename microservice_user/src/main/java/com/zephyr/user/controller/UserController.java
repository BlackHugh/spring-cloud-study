package com.zephyr.user.controller;

import com.zephyr.user.pojo.User;
import com.zephyr.user.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserServiceImpl userService;

    @Value("${server.port}")
    private Integer serverPort;

    @GetMapping("")
    public List<User> getAllUsers(){
//        List<User>result =  new ArrayList<>();
//        result.add(new User(1,"one","123","male",1000.0));
//        result.add(new User(2,"two","123","female",1000.0));
//        result.add(new User(3,"three","123","male",1000.0));

        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id){
        logger.info(String.valueOf(serverPort));
        System.out.println(serverPort);
        return userService.findById(id).get();
    }

    @PostMapping("")
    public String add(@RequestBody User user){
        userService.save(user);
        return "success";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Integer id, @RequestBody User user){
        user.setId(id);
        userService.save(user);
        return "success";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        userService.deleteById(id);
        return "success";
    }
}
