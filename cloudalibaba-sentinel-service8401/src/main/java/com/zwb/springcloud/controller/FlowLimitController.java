package com.zwb.springcloud.controller;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB()
    {
        return "-------testB";
    }

    @GetMapping("/testD")
    public String testD()
    {
//           try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        log.info("testD 测试RT");
        log.info("testD 异常比例");
        int age = 10/0;
        return "-------testD";
    }

    @GetMapping("/testE")
    public String testE()
    {
        log.info("testE 异常比例");
        int age = 10/0;
        return "-------testD 测试异常比例";
    }

    @GetMapping("/testHotkey")
    @SentinelResource(value = "testHotkey",blockHandler = "deal_testHotkey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2)
    {
        return "---------testHotkey";
    }

    public String deal_testHotkey(String p1, String p2, BlockException exception)
    {
        //自定义服务降级出现界面
        return "---------deal_testHotkey";
    }


}
