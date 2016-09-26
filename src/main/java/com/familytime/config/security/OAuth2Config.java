package com.familytime.config.security;

import com.familytime.config.Persistence;
import com.familytime.security.model.provider.implementation.UserAuthenticationManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

/**
 * OAuth2 config.
 */
@Profile("default")
@Configuration
@EnableAuthorizationServer
@Import(Persistence.class)
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private UserAuthenticationManager authenticationManager;

    @Autowired
    Persistence persistence;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
        .authenticationManager(authenticationManager);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
            .withClient("familyTime")
            .secret("chromeriver")
            .scopes("read","write")
            .autoApprove(true)
            .authorizedGrantTypes("password","authorization_code", "refresh_token")
            .accessTokenValiditySeconds(900);
    }
}
