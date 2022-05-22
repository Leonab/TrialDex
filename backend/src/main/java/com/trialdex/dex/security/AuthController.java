package com.trialdex.dex.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AuthController {

    @GetMapping("/rest/auth")
    public String authenticate() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info(String.valueOf(authentication.isAuthenticated()));
        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;

        Jwt jwt = (Jwt) token.getDetails();
        String aToken = jwt.getTokenValue();
        log.info(aToken);

        return aToken;
    }
}
