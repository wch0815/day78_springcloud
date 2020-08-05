package com.cheng.service;

import com.cheng.pojo.User;

import java.util.List;

public interface IUserService {

    List<User> getAllUsers();

    User getUserByUid(int uid);

    boolean saveUser(User u);

}
