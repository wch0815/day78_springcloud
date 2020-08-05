package com.cheng.dao;

import com.cheng.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IUserDao {

    @Select("select * from tb_user")
    List<User> getAllUsers();

    @Select("select * from tb_user where uid=#{uid}")
    User getUserByUid(int uid);

    @Insert("insert into tb_user values(null,#{username},#{password})")
    int saveUser(User u);
}
