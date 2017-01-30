/** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *
 *                                                                  *
 * @copyright 2016 (c), by Valentine
 *
 * @author <a href="mailto:valentunnamisnuk@gmail.com">Valentyn Namisnyk</a>
 *
 * @date 2017-20-01 19:35:40
 *
 * @address /Ukraine/Ivano-Frankivsk/Rozhniw
 *                                                                  *
 *///*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *

package com.familytime.model.service;

import com.familytime.model.entity.Family;

import org.springframework.security.core.userdetails.User;

/**
 * Service for getting data from security context.
 */
public interface SecurityService {

    /**
     * Get family of Logged person.
     *
     * @return Family of logged user.
     */
    public Family getFamilyOfLoggedUser();
}
