package com.zwb.springcloud.service;

import entities.CommonResult;
import entities.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService
{
    @Override
    public CommonResult<Payment> paymentSQL(long id) {
        return new CommonResult<>(444,"服务降级返回，---PaymentFallbackService");
    }
}
