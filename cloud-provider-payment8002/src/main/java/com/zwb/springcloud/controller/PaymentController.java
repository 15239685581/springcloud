package com.zwb.springcloud.controller;
import com.zwb.springcloud.service.PaymentService;
import entities.CommonResult;
import entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController
{
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment)
    {
        int result = paymentService.create(payment);
        log.info("*******插入结果："+result);
        if (result >0)
        {
            return new CommonResult(200,"插入数据成功"+serverPort,result);
        }else
        {
            return new CommonResult(444,"插入数据库失败"+serverPort,null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") long id)
    {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*******插入结果："+payment);
        int age = 10/2;
        if (payment != null)
        {
            return new CommonResult(200,"查询成功"+serverPort,payment);
        }else
        {
            return new CommonResult(444,"没有对应记录，查询ID:"+id+""+serverPort,null);
        }
    }

    @GetMapping(value="/payment/discovery")
    public Object discovery()
    {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("*****element:"+element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }
}
