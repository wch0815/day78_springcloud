package com.cheng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients     //开启对feign的支持
@EnableCircuitBreaker   //开启熔断
public class HystrixFeignConsumerStarter {
    public static void main(String[] args) {
        SpringApplication.run(HystrixFeignConsumerStarter.class,args);
    }
}
