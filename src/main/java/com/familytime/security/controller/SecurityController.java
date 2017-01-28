/** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *
 *                                                                  *
 * @copyright 2016 (c), by Valentine
 *
 * @author <a href="mailto:valentunnamisnuk@gmail.com">Valentyn Namisnyk</a>
 *
 * @date 2016-25-08 20:14:16 ::
 *
 * @address /Ukraine/Ivano-Frankivsk/Rozhniw
 *                                                                   *
 *///*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *

package com.familytime.security.controller;

import com.familytime.model.entity.Family;
import com.familytime.model.entity.Role;
import com.familytime.model.entity.User;
import com.familytime.model.service.FamilyService;
import com.familytime.model.service.RoleService;
import com.familytime.model.service.UserService;
import com.familytime.security.model.entity.Roles;
import com.familytime.security.view.form.RegistrationForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping( value = "/security" )
public class SecurityController {

    /// *** Properties  *** ///
    //- SECTION :: CRYPTOGRAPHY -//
    /**
     * Encoder for create hash of password.
     */

    //- SECTION :: SERVICES -//
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    FamilyService familyService;

    /// *** Methods     *** ///
    //- SECTION :: ACTIONS -//

    /**
     * Registration a new user.
     *
     * @param registrationForm  Data from registration form for register a new user.
     * @param response          Use for work with HTTP.
     *
     * @return User Created user.
     */
    @RequestMapping( value = "/signup", method = RequestMethod.POST)
    @ResponseBody
    public User registrationAction(
        @RequestBody
        @Valid
        final RegistrationForm registrationForm,

        HttpServletResponse response
    ) {
        try {
            //Get role "parent"
            Role roleParent = roleService.findByAuthority(Roles.PARENT.name());

            if (roleParent == null) {
                response.setStatus( HttpServletResponse.SC_NOT_FOUND );
                return null;
            }
            //Create list of roles
            List<Role> userRoles = new ArrayList<>();
            userRoles.add(roleParent);

            //Create new user
            User newUser = new User(
                new Family(registrationForm.getFamilyName()), //create new role
                registrationForm.getFirstName(),
                registrationForm.getLastName(),
                registrationForm.getMiddleName(),
                registrationForm.getUsername(),
                registrationForm.getPassword(),
                registrationForm.getBirthday(),
                registrationForm.getGender(),
                registrationForm.getLocale(),
                true, // parent status
                true, // active
                userRoles
            );

            //- Success -//
            response.setStatus(HttpServletResponse.SC_CREATED);

            //- Persist -//
            return this.userService.create(newUser);
        } catch (DataIntegrityViolationException | IllegalArgumentException e ) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }

        return null;
    }
}
