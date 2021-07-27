package com.zwb.springcloud.controller;

import com.zwb.springcloud.domain.CommonResult;
import com.zwb.springcloud.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    @PostMapping("/storage/decrease")
    public CommonResult decrease(long productId,Integer count)
    {
       storageService.decrease(productId,count);
        return new CommonResult(200,"扣减库存成功");
    }
}
