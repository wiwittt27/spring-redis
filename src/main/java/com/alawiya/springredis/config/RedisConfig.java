package com.alawiya.springredis.config;

import com.alawiya.springredis.config.properties.ApplicationConstant;
import com.alawiya.springredis.model.redis;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

@Configuration
@Slf4j
@EnableCaching
public class RedisConfig {
    private final redis.CacheConfigProperties cacheConfigProperties;


    public RedisConfig(redis.CacheConfigProperties cacheConfigProperties) {
        this.cacheConfigProperties = cacheConfigProperties;
    }

    @Bean(ApplicationConstant.BEAN_REDIS)
    public RedisConnectionFactory redisConnectionFactoryConfig() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(cacheConfigProperties.getHost(), cacheConfigProperties.getPort());
        redisStandaloneConfiguration.setPassword(cacheConfigProperties.getPassword());
        log.info("[-----Connected to Redis Factory-----] : [{}:{}]", cacheConfigProperties.getHost(), cacheConfigProperties.getPort());
        return new JedisConnectionFactory(redisStandaloneConfiguration);
    }
}
