package com.cheng.controller;

import com.cheng.pojo.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/consumer")
public class UserController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return restTemplate.getForObject("http://localhost:8000/user/all",List.class);
    }

    @GetMapping("/all/{uid}")
    public User getUserByUid(@PathVariable int uid){
        return restTemplate.getForObject("http://localhost:8000/user/all/"+uid,User.class);
    }

    @PostMapping("/save")
    public String saveUser(@RequestBody User u){
        return restTemplate.getForObject("http://localhost:8000/user/save",String.class);
    }
}
