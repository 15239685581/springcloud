package com.zwb.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import entities.CommonResult;
import entities.Payment;

public class CustomerBlockHandler {

    public static CommonResult handlerException1(BlockException exception)
    {
        return new CommonResult(444,"按客户要求自定义,global handlerException---1");
    }

    public static CommonResult handlerException2(BlockException exception)
    {
        return new CommonResult(444,"按客户要求自定义,global handlerException---2");
    }
}
