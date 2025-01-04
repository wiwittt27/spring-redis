package com.alawiya.springredis.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Data
@Configuration
@ConfigurationProperties("app")
public class ApplicationProperties {
    private Map<String, String> INTERNAL_CATALOGUE_CLIENT = new HashMap<>();

    private String URI_INTERNAL_CATALOGUE = "/api/v1/config/find-catalogue/[alias]/[catalogue]";
    private String ALIAS = "0";
    private String PRODUCTCAT = "PRODUCT_CONFIGURATION";
    private int INTERNAL_CATALOGUE_TIMEOUT = 5000;
}
