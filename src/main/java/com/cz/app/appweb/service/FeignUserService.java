package com.cz.app.appweb.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "USERSERVICE",fallback = FeignUserServiceHystric.class)
public interface FeignUserService {
    @RequestMapping("/hi")
    String sayHiByfeign(@RequestParam("name")String name);
}
