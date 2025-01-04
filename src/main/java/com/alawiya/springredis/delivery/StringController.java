package com.alawiya.springredis.delivery;

import com.alawiya.springredis.model.User;
import com.alawiya.springredis.model.redis;
import com.alawiya.springredis.model.rs.ResponseInfo;
import com.alawiya.springredis.services.RedisStringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/string")
public class StringController {

    @Autowired
    RedisStringService repository;
    @Autowired
    redis.CacheConfigProperties cacheConfigProperties;


    @PostMapping("/save")
    public ResponseEntity<?> saveDataString(@RequestParam String key, @RequestBody User value) {
        repository.saveRedisString(key, String.valueOf(value));
        HashMap<String, Object> rs = new HashMap<>();
        rs.put("key", key);
        rs.put("value", value);
        rs.put("ttl", cacheConfigProperties.getTtl());
        return ResponseEntity.ok(rs);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getDataString(@RequestParam String key) {
      ResponseInfo rs =  repository.getData(key);
        return new  ResponseEntity<>(rs.getBody(),rs.getHttpHeaders(),rs.getHttpStatus());
    }


    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteDataString(@RequestParam String key){
        ResponseInfo rs = repository.deleteRedisString(key);
        return new  ResponseEntity<>(rs.getBody(),rs.getHttpHeaders(),rs.getHttpStatus());
    }
}
