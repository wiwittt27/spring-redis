package com.alawiya.springredis.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@RedisHash("UserHash")
public class UserHash implements Serializable {
    @Id
    String id;
    String name;

}
