package com.trialdex.dex.config;

import com.trialdex.dex.security.services.CustomAuthSuccessHandler;
import com.trialdex.dex.security.services.CustomOidcUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.jwt.JwtDecoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("customClientRegistrationRepository")
    public ClientRegistrationRepository clientRegistrationRepository;

    @Autowired
    @Qualifier("customOidcUserService")
    public CustomOidcUserService oidcUserService;

    @Autowired
    public CustomAuthSuccessHandler successHandler;

    @Autowired
    public JwtDecoder jwtDecoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests(a -> a
                        .antMatchers("/", "/error", "/health", "/login").permitAll()
                        .anyRequest().authenticated()
                )
                .logout(l -> l
                        .logoutSuccessUrl("/login").permitAll()
                );

        http
                .oauth2Login()
                .successHandler(successHandler)
                .clientRegistrationRepository(clientRegistrationRepository)
                .userInfoEndpoint(userInfoEndpointConfig ->
                        userInfoEndpointConfig
                                .oidcUserService(oidcUserService));

        http
                .oauth2ResourceServer()
                .jwt()
                .decoder(jwtDecoder);
    }
}
