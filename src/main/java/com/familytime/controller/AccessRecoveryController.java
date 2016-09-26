/** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *
 *                                                                  *
 * @copyright 2016 (c), by Valentine
 *
 * @author <a href="mailto:valentunnamisnuk@gmail.com">Valentyn Namisnyk</a>
 *
 * @date 2016-07-10 22:40:59 ::
 *
 * @address /Ukraine/Ivano-Frankivsk/Rozhniw
 *                                                                  *
 *///*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *

package com.familytime.controller;

import com.familytime.notification.model.entity.EmailAddress;
import com.familytime.security.model.entity.RecoveryAccess;
import com.familytime.security.model.service.AccessRecoveryService;
import com.familytime.security.view.form.PasswordRecoveryForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Controller fot access recovery.
 *
 * @version 1.0
 */
@RestController
@RequestMapping( value = "/passRecovery/" )
public class AccessRecoveryController {

    @Autowired
    AccessRecoveryService accessRecoveryService;

    /**
     * Generate hash. Sed email with link to user.
     *
     * @param emailAddress Users email.
     * @param response     Http response.
     */
    @RequestMapping( value = "forgotPass", method = RequestMethod.POST )
    @ResponseBody
    public void requestRecoveryCheck(
            @RequestBody
            @Valid
            final EmailAddress emailAddress,
            HttpServletResponse response) {

        try {
            //Send email with link to user
            accessRecoveryService.lostAccess(emailAddress);

            //- Success -//
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (IOException e) {
            response.setStatus( HttpServletResponse.SC_INTERNAL_SERVER_ERROR );
        }
    }

    /**
     * Change password.
     *
     * @param passwordRecoveryForm New password and hash.
     * @param response Http response.
     */
    @RequestMapping( value = "changePass", method = RequestMethod.POST )
    @ResponseBody
    public void changePassword(
            @RequestBody
            @Valid
            PasswordRecoveryForm passwordRecoveryForm,
            HttpServletResponse response) {

        try {
            //Change user password
            accessRecoveryService.restore(passwordRecoveryForm.getHash(), passwordRecoveryForm.getPassword());

            //- Success -//
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (DataIntegrityViolationException | IllegalArgumentException e) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }

    /**
     * Check access hash.
     *
     * @param hash One-time hash.
     */
    @RequestMapping( value = "checkAccess", method = RequestMethod.POST )
    @ResponseBody
    public void changePassword(
            @RequestBody
            String hash,
            HttpServletResponse response) {

        try {
            //checkHash
            RecoveryAccess recoveryAccess = accessRecoveryService.getValidAccess(hash);

            if (recoveryAccess == null) {
                //Failure
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            } else {
                //- Success -//
                response.setStatus(HttpServletResponse.SC_OK);
            }
        } catch (DataIntegrityViolationException | IllegalArgumentException e) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }
}
