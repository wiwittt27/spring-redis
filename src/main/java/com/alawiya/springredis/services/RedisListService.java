package com.alawiya.springredis.services;

import com.alawiya.springredis.model.User;
import com.alawiya.springredis.model.rs.GenericRs;
import com.alawiya.springredis.model.rs.ResponseInfo;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisListService {
    private final RedisTemplate<String, User> redisTemplate;

    public RedisListService(@Qualifier("list-redis") RedisTemplate<String, User> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void pushLeft(String key, User listValue) {
        redisTemplate.opsForList().leftPush(key, listValue);
    }

    // Get all tasks from the list
    public ResponseInfo getAllDataKey(String listKey) {
        GenericRs body = new GenericRs();
        ResponseInfo responseInfo = new ResponseInfo().setBody(body);
        List<User> data = redisTemplate.opsForList().range(listKey, 0, -1);
        responseInfo.setSuccess(data);
        return responseInfo;
    }

    public ResponseInfo pushRight(String key, User valueList){
        GenericRs body = new GenericRs();
        ResponseInfo responseInfo = new ResponseInfo().setBody(body);

        redisTemplate.opsForList().rightPush(key, valueList);
        responseInfo.setSuccess();
        return responseInfo;
    }
}
