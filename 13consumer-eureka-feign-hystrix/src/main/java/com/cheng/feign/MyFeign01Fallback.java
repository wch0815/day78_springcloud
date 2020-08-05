package com.cheng.feign;

import com.cheng.pojo.Users;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyFeign01Fallback implements FeignClient01 {
    @Override
    public Users getUserById(int uid) {
        Users users = new Users();
        users.setUid(-200);
        users.setUsername("hhhhhh");
        return users;
    }

    @Override
    public List<Users> getAllUser() {
        return null;
    }
}
