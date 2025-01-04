package com.alawiya.springredis.config.properties;

import lombok.Data;
import org.springframework.context.annotation.Configuration;


public class ApplicationConstant {

    public static final String BEAN_REDIS = "redis-config";
    public interface CACHE{
        String SPRING_CACHE = "config-cache";
    }
}
