package com.trialdex.dex.security.services;

import com.trialdex.dex.models.User;
import com.trialdex.dex.repositories.IUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class CustomOidcUserService implements OAuth2UserService<OidcUserRequest, OidcUser> {

    private final Set<String> googleScopes;
    private final IUserRepository userRepository;

    public CustomOidcUserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
        googleScopes = new HashSet<>();
        googleScopes.add(
                "https://www.googleapis.com/auth/userinfo.email");
        googleScopes.add(
                "https://www.googleapis.com/auth/userinfo.profile");
        googleScopes.add("openid");
    }

    @Override
    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {

        final OidcUserService userService = new OidcUserService();
        userService.setAccessibleScopes(googleScopes);

        OidcUser oidcUser = userService.loadUser(userRequest);

        Optional<User> userOptional = userRepository.findByEmail(oidcUser.getEmail());
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//        oidcUser.getClaims()
//                .forEach((key, value) -> grantedAuthorities.add(new SimpleGrantedAuthority(value.toString())));
        if (!userOptional.isPresent()) {
            User user = new User();
            user.setUsername(oidcUser.getFullName());
            user.setEmail(oidcUser.getEmail());

            userRepository.save(user);
        }
        oidcUser = new DefaultOidcUser(grantedAuthorities, oidcUser.getIdToken(), oidcUser.getUserInfo());
        log.info(oidcUser.toString());

        return oidcUser;
    }
}
