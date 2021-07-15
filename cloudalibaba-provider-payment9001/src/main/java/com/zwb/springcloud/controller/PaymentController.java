package com.zwb.springcloud.controller;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value="/payment/Nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id)
    {
        return "nacos registry ,serverport:"+serverPort+"\t id"+id;
    }
}