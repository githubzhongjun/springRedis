package com.example.springredis.client;

import com.example.springredis.constant.CacheKey;
import com.example.springredis.entity.User;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedissonTemplateClient {

    @Autowired
    private RedissonClient redissonClient;

    @GetMapping(value = "redissonTemplate/create")
    public String createData(String key, String data){
        //RBucketJava对象是一种通用对象桶可以用来存放任类型的对象。 除了同步接口外，还提供了异步（Async）、反射式（Reactive）和RxJava2标准的接口
        //详情可阅读 https://github.com/redisson/redisson/wiki/6.-%E5%88%86%E5%B8%83%E5%BC%8F%E5%AF%B9%E8%B1%A1
        RBucket<Object> bucket = redissonClient.getBucket(key);
        bucket.set(data);

        return "保存成功！";
    }

    @GetMapping(value = "redissonTemplate/query")
    public String queryData(String key){
        RBucket<Object> bucket = redissonClient.getBucket(key);
        Object o = bucket.get();

        return (String) o;
    }

    @GetMapping(value = "redissonTemplate/create/user")
    public String createUser(Integer id){
        User user = new User(id,"zhongjun", 25, "超能力");
        RBucket<Object> bucket = redissonClient.getBucket(CacheKey.USER_KEY+id.toString());
        bucket.set(user);

        return "保存成功！";
    }

}
