package com.zwb.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Configuration
public class ApplicationContextConfig {

    @Bean
    //负载均衡
    @LoadBalanced
    public RestTemplate getRestTemplate()
   {
       return new RestTemplate();
   }
}
