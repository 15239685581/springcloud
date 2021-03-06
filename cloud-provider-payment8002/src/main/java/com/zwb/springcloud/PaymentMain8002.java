package com.zwb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//可以是其他注册中心
@EnableDiscoveryClient
public class PaymentMain8002 {

    public static void main(String[] args)
    {
        SpringApplication.run(PaymentMain8002.class,args);
    }
}
