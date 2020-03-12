package com.cz.app.appweb.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    RestTemplate restTemplate;

    /**注解断路器fallBackMethod**/
    @HystrixCommand(fallbackMethod = "getUserNameError")
    public String getUserName(String name){
        return restTemplate.getForObject("http://USERSERVICE/hi?name="+name,String.class);
    }

    public String getUserNameError(String name){
        return "sorry ,getUserNameError!";
    }
}
