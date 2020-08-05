package com.cheng.service.impl;

import com.cheng.dao.IUserDao;
import com.cheng.pojo.User;
import com.cheng.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private IUserDao userDao;

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserByUid(int uid) {
        return userDao.getUserByUid(uid);
    }

    @Override
    public boolean saveUser(User u) {
        return userDao.saveUser(u) > 0;
    }
}
