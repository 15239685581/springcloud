package com.zwb.springcloud.service;
import com.zwb.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


public interface StorageService
{
    /**
     * 扣减库存
     */
    void decrease(Long productId,Integer count);
}
