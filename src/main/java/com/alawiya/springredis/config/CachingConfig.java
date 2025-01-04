package com.alawiya.springredis.config;

import com.alawiya.springredis.config.properties.ApplicationConstant;
import com.alawiya.springredis.model.User;
import com.alawiya.springredis.model.redis;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
@EnableCaching
public class CachingConfig {
    private final redis.CacheConfigProperties cacheConfigProperties;
    private final RedisConnectionFactory redisConnectionFactory;


    public CachingConfig(redis.CacheConfigProperties cacheConfigProperties, RedisConnectionFactory redisConnectionFactory) {
        this.cacheConfigProperties = cacheConfigProperties;
        this.redisConnectionFactory = redisConnectionFactory;
    }

    @Bean
    public RedisCacheManager redisCacheManager() {
        RedisCacheConfiguration cacheConfig = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(this.cacheConfigProperties.getTtl()))
                .disableCachingNullValues()
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));

        return RedisCacheManager.RedisCacheManagerBuilder
                .fromConnectionFactory(redisConnectionFactory)
                .withCacheConfiguration(ApplicationConstant.CACHE.SPRING_CACHE,cacheConfig)
                .build();
    }
    @Bean
    @Qualifier("list-redis")
    public RedisTemplate<String, User> redisTemplate() {
        RedisTemplate<String, User> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer()); // Serialize keys as strings
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer()); // Serialize values as JSON
        return template;
    }


}
