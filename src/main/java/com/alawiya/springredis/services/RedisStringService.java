package com.alawiya.springredis.services;

import com.alawiya.springredis.config.properties.ApplicationConstant;
import com.alawiya.springredis.model.User;
import com.alawiya.springredis.model.rs.GenericRs;
import com.alawiya.springredis.model.rs.ResponseInfo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class RedisStringService {


    private final StringRedisTemplate redisTemplate;

    public RedisStringService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void saveRedisString(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }
    public ResponseInfo deleteRedisString(String key){
        GenericRs body = new GenericRs();
        ResponseInfo responseInfo = new ResponseInfo().setBody(body);
        redisTemplate.delete(key);

        responseInfo.setSuccess("deleted");

        return responseInfo;
    }

    @Cacheable(value = ApplicationConstant.CACHE.SPRING_CACHE, key = "#key")
    public ResponseInfo getData(String key) {
        GenericRs body = new GenericRs();
        ResponseInfo responseInfo = new ResponseInfo().setBody(body);

        String data = redisTemplate.opsForValue().get(key);
        String[] partString = data.split(":");

        User user = new User();
        user.setId(partString[0]);
        user.setName(partString[1]);

        responseInfo.setSuccess(user);
        return responseInfo;
    }
}
