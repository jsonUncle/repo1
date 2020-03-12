package com.cz.app.appweb.controller;

import com.cz.app.appweb.service.FeignUserService;
import com.cz.app.appweb.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class AppController {
    @Autowired
    UserService userService;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    FeignUserService feignUserService;

    @RequestMapping("/hi")
    @HystrixCommand(fallbackMethod = "getUserNameError")
    public String hi(@RequestParam String name){
        return restTemplate.getForObject("http://USERSERVICE/hi?name="+name,String.class);
    }

    @RequestMapping("/feignHi")
    public String feign(String name){
        return feignUserService.sayHiByfeign(name);
    }


    public String getUserNameError(String name){
        return "sorry ,getUserNameError!";
    }
}
