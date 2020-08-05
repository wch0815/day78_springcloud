package com.cheng.controller;

import com.cheng.pojo.User;
import com.cheng.service.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/all/{uid}")
    public User getUserByUid(@PathVariable int uid){
        return userService.getUserByUid(uid);
    }

    @PostMapping("/save")
    public boolean saveUser(@RequestBody User u){
        return userService.saveUser(u);
    }

}
