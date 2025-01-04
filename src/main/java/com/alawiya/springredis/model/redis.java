package com.alawiya.springredis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

public class redis {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Configuration
    @ConfigurationProperties("redis-spring")
    public static class CacheConfigProperties {
        private String host;
        private int port;
        private String password;
        private int ttl;
    }
}
