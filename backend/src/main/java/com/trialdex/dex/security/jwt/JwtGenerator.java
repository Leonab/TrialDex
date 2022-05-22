package com.trialdex.dex.security.jwt;

import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import com.trialdex.dex.config.properties.JwtConfigurationProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;
import org.springframework.security.oauth2.jose.jws.SignatureAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JwtGenerator {

    private final ClientRegistrationRepository repository;
    private final JWKSource<SecurityContext> jwkSource;
    private final JwtConfigurationProperties properties;

    public Jwt generate() {
        JwtEncoder encoder = new NimbusJwtEncoder(jwkSource);

        JwsHeader.Builder headersBuilder = JwsHeader.with(SignatureAlgorithm.RS256);
        JwtClaimsSet.Builder claimsBuilder = JwtClaimsSet.builder();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Instant issuedAt = Instant.now();
        Instant expiresAt = issuedAt.plus(properties.getDurationValid(), ChronoUnit.MINUTES);
        claimsBuilder
                .subject(authentication.getName())
                .issuer(properties.getIssuer())
                .audience(Collections.singletonList(repository.findByRegistrationId("google").getClientId()))
                .issuedAt(issuedAt)
                .expiresAt(expiresAt)
                .notBefore(issuedAt);

        String scopes = authentication.getAuthorities().stream()
                .map(Object::toString)
                .collect(Collectors.joining(" "));

        claimsBuilder.claim(OAuth2ParameterNames.SCOPE, scopes);

        JwsHeader headers = headersBuilder.build();
        JwtClaimsSet claims = claimsBuilder.build();

        return encoder.encode(JwtEncoderParameters.from(headers, claims));
    }
}
