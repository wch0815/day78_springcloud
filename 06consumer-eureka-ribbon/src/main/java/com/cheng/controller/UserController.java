package com.cheng.controller;

import com.cheng.pojo.User;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ribbonConsumerEureka")
public class UserController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancerClient client;

    @GetMapping("/all")
    public List<User> getAllUser(){

        return restTemplate.getForObject("http://04provider-eureka/user/all",List.class);
    }

    @GetMapping("/all/{uid}")
    public User getUserByUid(@PathVariable int uid){

        return restTemplate.getForObject("http://04provider-eureka/user/all/"+uid,User.class);
    }

    @PostMapping("/save")
    public String saveUser(@RequestBody User u){

        return restTemplate.postForObject("http://04provider-eureka/user/save",u,String.class);
    }

    @GetMapping("/test")
    public String hello(){
        int port = client.choose("04provider-eureka").getPort();
        return "world" + port;
    }
}
