package com.example.springredis.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisTemplateClient {

    //RedisTemplate: 默认采用JDK序列化方式 以字符数组存取 \
    //              （用这个方式会导致应用根据key,能查询到指定的value; 而redis服务端查询不到）
    //StringRedisTemplate: 采用String序列化方式 以字符串方式存取
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping(value = "redisTemplate/create")
    public String createData(String key, String data){
        stringRedisTemplate.opsForValue().set(key, data);

        return "保存成功！";
    }

    @GetMapping(value = "redisTemplate/query")
    public String queryData(String key){
        String data = stringRedisTemplate.opsForValue().get(key);

        return data;
    }

}
