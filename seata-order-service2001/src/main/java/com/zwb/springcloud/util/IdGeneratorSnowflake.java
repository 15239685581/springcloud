package com.zwb.springcloud.util;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.PublicKey;

@Slf4j
@Component
//雪花算法
public class IdGeneratorSnowflake
{
    private long workerId = 0;
    private long datacenterId = 1;
    private Snowflake snowflake = IdUtil.createSnowflake(workerId,datacenterId);

    @PostConstruct//初始化注解
    public void inin()
    {
        try {
            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
            log.info("当前机器的workId: {}",workerId);
        }catch (Exception e)
        {
            e.printStackTrace();
            log.warn("当前机器的workerId获取失败",e);
            workerId = NetUtil.getLocalhostStr().hashCode();
        }
    }
    public synchronized  long snowflakeId()
    {
        return snowflake.nextId();
    }

    public synchronized  long snowflakeId(long workerId,long datacenterId)
    {
        snowflake = IdUtil.createSnowflake(workerId,datacenterId);
        return snowflake.nextId();
    }

    public static void main(String[] args) {
        System.out.println(new IdGeneratorSnowflake().snowflakeId());
    }


}
