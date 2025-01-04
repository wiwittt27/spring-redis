package com.alawiya.springredis.repository;

import com.alawiya.springredis.model.UserHash;
import org.springframework.data.repository.CrudRepository;

public interface RedisHashRepository extends CrudRepository<UserHash,String> {
}
