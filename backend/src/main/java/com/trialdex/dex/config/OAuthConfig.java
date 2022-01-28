package com.trialdex.dex.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

@Configuration
public class OAuthConfig {

    public static String googleClientRegistration = "google";

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        ClientRegistration googleClient = CommonOAuth2Provider.GOOGLE
                .getBuilder(googleClientRegistration)
                .clientId(System.getenv("oauth-client-id"))
                .clientSecret(System.getenv("oauth-client-secret"))
                .build();

        return new InMemoryClientRegistrationRepository(googleClient);
    }
}
