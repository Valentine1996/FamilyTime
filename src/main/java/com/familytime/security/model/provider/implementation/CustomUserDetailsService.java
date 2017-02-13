package com.familytime.security.model.provider.implementation;

import com.familytime.model.entity.Role;
import com.familytime.model.entity.User;
import com.familytime.model.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service for getting user's details.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    /// *** Properties  *** ///
    @Autowired
    private UserService userService;

    /**
     * Create Auth user.
     *
     * @param userName - user's name.
     * @return UserDetails - details of the user.
     * @throws UsernameNotFoundException when user not found.
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.findByUsername(userName);

        //check if this user with this username exist, if not, throw an exception
        if (user == null) {
            throw new UsernameNotFoundException("User details not found with this username: "
                    + userName);
        }

        String username = user.getUsername();
        String password = user.getPassword();

        List<SimpleGrantedAuthority> authList = getAuthorities(user.getRoles());

        org.springframework.security.core.userdetails.User authUser
            = new org.springframework.security.core.userdetails.User(username, password, authList);

        return authUser;
    }

    /**
     * Convert user's roles to list of SimpleGrantedAuthority.
     *
     * @param roles - User's roles.
     * @return List of Simple Granted Authorities.
     */
    private List<SimpleGrantedAuthority> getAuthorities(List<Role> roles) {
        List<SimpleGrantedAuthority> authList = new ArrayList<>();

        //Adding user's roles as Simple Granted Authorities
        if (roles != null) {
            for (Role role : roles) {
                authList.add(new SimpleGrantedAuthority(role.getAuthority()));
            }
        }

        return authList;
    }
}
