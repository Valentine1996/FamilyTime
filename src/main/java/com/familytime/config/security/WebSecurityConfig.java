/** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *
 *                                                                  *
 * @copyright 2016 (c), by Valentine
 *
 * @author <a href="mailto:valentunnamisnuk@gmail.com">Valentyn Namisnyk</a>
 *
 * @date 2016-25-08 20:57:16 ::
 *
 * @address /Ukraine/Ivano-Frankivsk/Rozhniw
 *                                                                  *
 *///*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***

package com.familytime.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

/**
 * Security config.
 */
@Profile("default")
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * PasswordConfig.
     *
     * @return ShaPassword
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//            .antMatchers("/**").permitAll()
//            .and().apply()
//    }
}
