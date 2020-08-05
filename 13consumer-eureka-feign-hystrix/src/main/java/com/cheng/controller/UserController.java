package com.cheng.controller;

import com.cheng.feign.FeignClient01;
import com.cheng.feign.MyFeign01Fallback;
import com.cheng.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/hystrixFeignConsumerStarter")
public class UserController {


    @Autowired
    private MyFeign01Fallback feignClient;

    @GetMapping("/all/{uid}")
    public Users getUserByUid(@PathVariable int uid){
        return feignClient.getUserById(uid);
    }

    @GetMapping("/all")
    public List<Users> getAllUsers(){
        return feignClient.getAllUser();
    }
}
