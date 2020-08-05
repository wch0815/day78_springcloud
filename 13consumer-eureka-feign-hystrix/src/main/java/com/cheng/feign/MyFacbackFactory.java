package com.cheng.feign;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class MyFacbackFactory implements FallbackFactory<FeignClient01> {
    @Override
    public FeignClient01 create(Throwable throwable) {
        return new MyFeign01Fallback();
    }
}
