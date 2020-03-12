package com.cz.app.appweb.service;

import org.springframework.stereotype.Component;

@Component
public class FeignUserServiceHystric implements FeignUserService{


    @Override
    public String sayHiByfeign(String name) {
        return "feign say hi error";
    }
}
