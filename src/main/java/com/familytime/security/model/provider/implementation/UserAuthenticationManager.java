package com.familytime.security.model.provider.implementation;

import com.familytime.model.entity.User;
import com.familytime.model.service.UserService;
import com.familytime.security.model.entity.AuthenticationToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by valentyn on 8/2/16.
 */
@Component
public class UserAuthenticationManager implements AuthenticationManager {

    /// *** Properties  *** ///
    //- SECTION :: CRYPTOGRAPHY -//
    /**
     * Encoder for create hash of password.
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    /// *** Methods     *** ///
    //- SECTION :: MAIN -//
    
    /**
     * Attempts to authenticate the passed {@link org.springframework.security.core.Authentication}
     * object, returning a fully populated <code>Authentication</code> object (including granted
     * authorities) f successful.
     *
     * @param authentication the authentication request object
     * @return a fully authenticated object including credentials
     * @throws org.springframework.security.core.AuthenticationException if authentication fails
     */
    @Override
    public Authentication authenticate( 
        Authentication authentication ) throws AuthenticationException {
        //- Search user -//
        boolean testPassword;

        User user = this.userService.findByUsername(
            authentication.getPrincipal().toString()
        );

        if ( user != null ) {
            testPassword = BCrypt.checkpw(
                authentication.getCredentials().toString(), user.getPassword());
        } else {
            throw new BadCredentialsException( "Bad user credentials" );
        }

        if ( testPassword ) {
            //- Set authorities -//
            List<GrantedAuthority> authorities = new ArrayList<>();

            //- Populate roles into authentication object -//
            user.getRoles().forEach(
                role -> authorities.add(
                    new SimpleGrantedAuthority(
                        role.getAuthority()
                    )
                )
            );

            //- Create new auth token -//
            AuthenticationToken authToken = new AuthenticationToken(
                authentication.getPrincipal(),
                authentication.getAuthorities(),
                authorities
            );

            return authToken;
        } else {
            throw new BadCredentialsException( "Bad user credentials" );
        }
    }
}
