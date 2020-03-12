package com.cz.app.appweb;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import com.netflix.hystrix.contrib.requests.stream.HystrixRequestEventsSseServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
/**消费者注解*/
@EnableDiscoveryClient
/**feign**/
@EnableFeignClients
/**断路器**/
@EnableHystrix
/**断路器仪表盘可以根据页面看状态**/
@EnableHystrixDashboard
public class AppwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppwebApplication.class, args);
    }

    @Bean
    /**ribbon实现负载均衡**/
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
    /**配置url的hystrix监控**/
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }

}
