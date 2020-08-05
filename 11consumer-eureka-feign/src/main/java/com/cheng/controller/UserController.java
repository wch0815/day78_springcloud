package com.cheng.controller;

import com.cheng.feign.FeignClient01;
import com.cheng.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userconsumerfeign")
public class UserController {
    @Autowired //此处不需要我们手动创建这个对象,spring会自动帮我们创建,因为这个接口上面有注解
    private FeignClient01 feignClient01;

    @GetMapping("/all/{uid}")
    public Users getUserById(@PathVariable int uid) throws Exception {
        return feignClient01.getUserById(uid);
    }

    @GetMapping("/all")
    public List<Users> getAllUsers(){
        return feignClient01.getAllUsers();
    }

    @PostMapping("/save")
    public String addUser(@RequestBody Users user) {
        String result = feignClient01.save(user);
        return result;
    }

}