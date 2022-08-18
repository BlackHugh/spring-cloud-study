package com.zephyr.movie.controller;

//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zephyr.movie.client.UserController;
import com.zephyr.movie.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/movie")
@Api(description = "电影")
public class MovieController {

    private static final Logger log = LoggerFactory.getLogger(MovieController.class);

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private UserController userController;

    //without eureka
//    @PostMapping("/order")
//    public String order(){
//        //mock user
//        Integer id = 2;
//        //get user
//        User user = restTemplate.getForObject("http://localhost:9001/user/"+id, User.class);
//        System.out.println(user.getUsername()+" is ordering ticket...");
//
//        return "success";
//    }


//    resttemplate+annotation ribbon
//    @PostMapping("/order")
//    public String order(){
//        //mock user
//        Integer id = 2;
//        String url = new StringBuilder().append("http://").append("microservice-user")
//                .append("/user/").append(id).toString();
//        //get user
//        User user = restTemplate.getForObject(url, User.class);
//        System.out.println(user.getUsername()+" is ordering ticket...");
//
//        return "success";
//    }

//    ribbonclient +resttemplate 在使用这个方案的时候，@LoadBalance不能使用
//    @Autowired
//    private LoadBalancerClient client;
//    @PostMapping("/order")
//    public String order(){
//        ServiceInstance instance = client.choose("microservice-user");
//        //mock user
//        Integer id = 2;
//        String url = new StringBuilder().append(instance.getUri())
//                .append("/user/").append(id).toString();
//
//        //get user
//        User user = restTemplate.getForObject(url, User.class);
//        System.out.println(user.getUsername()+" is ordering ticket...");
//
//        return "success";
//    }

//    //openfeign + embeded hytrix
    @PostMapping("/order")
    @ApiOperation(value="订票")
    public String order(){
        //mock user
        Integer id = 2;

        //get user
        User user = userController.findById(id);
//        System.out.println(user.getUsername()+" is ordering ticket...");
        log.info(user.getUsername()+" is ordering ticket...");
        return "success";
    }

    //    resttemplate+annotation ribbon+ hystrix
//    @PostMapping("/order")
//    @HystrixCommand(fallbackMethod = "fallback")
//    public String order(){
//        //mock user
//        Integer id = 2;
//        String url = new StringBuilder().append("http://").append("microservice-user")
//                .append("/user/").append(id).toString();
//        //get user
//        User user = restTemplate.getForObject(url, User.class);
//        System.out.println(user.getUsername()+" is ordering ticket...");
//
//        return "success";
//    }

    public String fallback(){
        return "服务暂时不可用，发生熔断...";
    }

}
