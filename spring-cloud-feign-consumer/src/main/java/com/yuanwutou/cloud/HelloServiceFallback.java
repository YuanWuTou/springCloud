package com.yuanwutou.cloud;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceFallback implements HelloService {

    @Override
    public String hello() {
        System.out.println("11111111111111");
        return "error";
    }
}
