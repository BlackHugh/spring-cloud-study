package com.zephyr.movie.client;


import com.zephyr.movie.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//
//用户微服务接口
//使用FeignClient
//检查path完整，并且variable不能省略value
@FeignClient(value="microservice-user", fallback = UserControllerImpl.class)
public interface UserController {

    @GetMapping("/user/{id}")
    public User findById(@PathVariable("id") Integer id);
}
