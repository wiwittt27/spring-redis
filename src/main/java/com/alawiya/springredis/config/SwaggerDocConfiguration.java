package com.alawiya.springredis.config;

import com.alawiya.springredis.config.properties.ApplicationProperties;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by FARIDZIF on 07/02/2019.
 */

@Configuration
public class SwaggerDocConfiguration {


    @Autowired
    private ApplicationProperties appProperties;

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("ss")
                        .version("1")
                );

    }
}
