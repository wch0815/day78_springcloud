package com.cheng.controller;

import com.cheng.pojo.User;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/consumerEureka")
public class UserController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private EurekaClient client;

    @GetMapping("/all")
    public List<User> getAllUser(){
        //从eureka服务器上获取指定名称的服务信息
        InstanceInfo info = client.getNextServerFromEureka("04provider-eureka",false);

        //获取地址，相当于http://localhost:8080
        String url = info.getHomePageUrl();
        return restTemplate.getForObject(url+"/user/all",List.class);
    }

    @GetMapping("/all/{uid}")
    public User getUserByUid(@PathVariable int uid){
        InstanceInfo info = client.getNextServerFromEureka("04provider-eureka",false);

        String url = info.getHomePageUrl();
        return restTemplate.getForObject(url+"/user/all/"+uid,User.class);
    }

    @PostMapping("/save")
    public String saveUser(@RequestBody User u){
        InstanceInfo info = client.getNextServerFromEureka("04provider-eureka",false);

        System.out.println(u);
        String url = info.getHomePageUrl();
        System.out.println(url);
        return restTemplate.postForObject(url+"/user/save",u,String.class);
    }
}
