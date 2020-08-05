package com.cheng.feign;

import com.cheng.pojo.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Created by jackiechan on 19-1-9/上午10:27
 *
 *
 */
//当配置fallback的时候,如果接口中的方法出现问题,就会去执行指定类里面的方法,因为类里面的方法可以随便写,所以这个类有特殊要求,必须实现当前feign接口
@FeignClient(value = "04provider-eureka",fallbackFactory = MyFacbackFactory.class)//声明当前接口是一个feignclient,参数为想访问哪个服务,写的是在eureka上面的服务的名字
public interface FeignClient01 {
    @GetMapping("/user/info/{uid}")
    Users getUserById(@PathVariable("uid") int uid);//注意在controller里面PathVariable的路径参数和方法的形参名字一样的时候可以忽略里面的名字.但是在feign里面必须写
    @PostMapping("/user/all")//这个方法上面只要有参数 就会被发出去,如果传递的是复杂对象,不管这里是不是GET都会以post方式发出去,出错还是不出错,取决于提供者那边的限定
    List<Users> getAllUser();

}
