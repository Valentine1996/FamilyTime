/** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *
 *                                                                  *
 * @copyright 2016 (c), by Valentine
 *
 * @author <a href="mailto:valentunnamisnuk@gmail.com">Valentyn Namisnyk</a>
 *
 * @date 2017-02-06 22:38:33 ::
 *
 * @address /Ukraine/Ivano-Frankivsk/Rozhniw
 *                                                                  *
 *///*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *

package com.familytime.controller;

import com.familytime.model.entity.Family;
import com.familytime.model.entity.User;
import com.familytime.model.service.SecurityService;
import com.familytime.model.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for users.
 *
 * @version 1.0
 */

@RestController
@RequestMapping( value = "/users" )
public class UserController {

    /// *** Properties  *** ///

    /**
     * Service for work with users.
     */
    @Autowired
    protected UserService userService;

    /**
     * Service for getting data from logged user.
     */
    @Autowired
    protected SecurityService securityService;

    /// *** Methods     *** ///

    /**
     * Get list of users.
     *
     * @return List of users.
     */
    @RequestMapping( method = RequestMethod.GET )
    @ResponseStatus( HttpStatus.OK )
    @ResponseBody
    public List<User> findAll() {

        //- Get user's family -/
        Family usersFamily = securityService.getFamilyOfLoggedUser();

        return this.userService.findByFamily(usersFamily);
    }
}
