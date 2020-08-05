package com.cheng.controller;

import com.cheng.pojo.Users;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/hystrixConsumer")
public class UserController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private EurekaClient eurekaClient;

    @GetMapping("/getAllUserByUid/{uid}")
    @HystrixCommand(fallbackMethod = "abc",commandProperties = {@HystrixProperty(name = "execution.isolation.strategy",value = "THREAD")})
    public Users getAllUserByUid(@PathVariable int uid) throws Exception{
        System.out.println("出错的线程"+Thread.currentThread().getName());
        //cong euerka上获取指定名字的服务的信息
        InstanceInfo info = eurekaClient.getNextServerFromEureka("04provider-eureka",false);
        //获取服务的地址 也就是 类似于http://localhost:8000
        String url = info.getHomePageUrl();
        System.out.println("服务提供者的地址:======>"+url);
        Users users = restTemplate.getForObject(url + "/user/all/" + uid, Users.class);
        return users;
    }

    public Users abc(int uid){
        Users user = new Users();
        user.setUid(-100);
        user.setUsername("刚才失败传递的id是:==>" + uid);
        return user;
    }
}
