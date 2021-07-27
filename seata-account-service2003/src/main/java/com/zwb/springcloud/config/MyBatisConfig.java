package com.zwb.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

//mybatis与seata整合配置
@Configuration
@MapperScan("com.zwb.springcloud.dao")
public class MyBatisConfig {
}
