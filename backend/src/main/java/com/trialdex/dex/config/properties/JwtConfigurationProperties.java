package com.trialdex.dex.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties("jwt.gen")
public class JwtConfigurationProperties {

    private String issuer;
    private Integer durationValid;
}
