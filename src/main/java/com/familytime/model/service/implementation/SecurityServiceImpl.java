package com.familytime.model.service.implementation;

import com.familytime.model.entity.Family;
import com.familytime.model.repository.UserRepository;
import com.familytime.model.service.SecurityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

/**
 * Implementation of security service.
 *
 * @version 1.0
 */
@Service
public class SecurityServiceImpl implements SecurityService {

    //-- PROPERTIES -//

    @Autowired
    UserRepository userRepository;

    //-- METHODS --//

    /**
     * Get family of Logged person.
     *
     * @return Family of logged user.
     */
    @Override
    public Family getFamilyOfLoggedUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName(); //get logged in username


        com.familytime.model.entity.User loggedUsersData = userRepository.findByUsername(username);

        if (loggedUsersData != null && loggedUsersData.getFamily() != null) {
            return loggedUsersData.getFamily();
        }
        return null;
    }

}
