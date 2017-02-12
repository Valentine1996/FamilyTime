/**
 * Created by Andrii Gaidychuk on 15.09.2016.
 */

package com.familytime.controller;

import static org.springframework.util.Assert.notNull;

import com.familytime.model.entity.Bonus;
import com.familytime.model.entity.BonusType;
import com.familytime.model.entity.Family;
import com.familytime.model.service.BonusService;
import com.familytime.model.service.SecurityService;
import com.familytime.view.form.BonusForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Controller for bonus.
 *
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/bonus")
public class BonusController {
    /// *** Properties  *** ///

    /**
     * Service for work with bonus.
     */
    @Autowired
    protected BonusService bonusService;

    /**
     * Service for getting data from logged user.
     */
    @Autowired
    protected SecurityService securityService;

    /// ***   Methods   *** ///

    /**
     * Get bonus by id.
     *
     * @param id          Id of Bonus.
     * @param response    Use for work with HTTP.
     * @return            Found Bonus.
     */
    @RequestMapping( value = "/{id}", method = RequestMethod.GET )
    @ResponseBody
    public Bonus findById(
            @PathVariable( "id" )
            Long id,

            HttpServletResponse response
    ) {
        try {
            //- Search requested bonus -//
            Bonus bonus = this.bonusService.findById(id);
            //- Check if bonus was found -//
            notNull(bonus);
            return bonus;
        } catch ( IllegalArgumentException e ) {
            //- Error. Cannot find this bonus type -//
            response.setStatus( HttpServletResponse.SC_NOT_FOUND );
        }

        return null;
    }

    /**
     * Get list of all bonuses.
     * @return List of all bonuses.
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Bonus> findAll() {
        return this.bonusService.findAll();
    }

    /**
     * Get list of bonuses by Family.
     * @return List of bonuses by Family.
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Bonus> findByFamily() {

        //- Get user's family -/
        Family usersFamily = securityService.getFamilyOfLoggedUser();
        return this.bonusService.findByFamily(usersFamily);
    }

    /**
     * Get list of bonuses by Bonus type.
     * @return List of bonuses by Bonus type.
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Bonus> findByBonusType(
            @RequestBody
            @Valid
            BonusForm bonusForm
    ) {
        try {
            if (bonusForm == null) {
                throw new DataIntegrityViolationException("Can not get data of the bonus");
            } else {
                //- Get bonus type and return List <Bonus> -/
                return this.bonusService.findByBonusType(bonusForm.getBonusType());
            }
        } catch (DataIntegrityViolationException e) {
            return  null;
        }
    }

    /**
     * Create a new bonus.
     * @param bonusForm   Form with input.
     * @param response    Use for work with HTTP.
     *
     * @return Created bonus.
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Bonus createAction(
            @RequestBody
            @Valid
            BonusForm bonusForm,

            HttpServletResponse response
    ) {
        try {
            //- Set HTTP status -//
            response.setStatus(HttpStatus.CREATED.value());

            if (bonusForm == null) {
                throw new DataIntegrityViolationException("Can not to create bonus");
            } else {
                //- Get bonus type -/
                BonusType bonusType = bonusForm.getBonusType();
                //Create new Bonus
                Bonus bonus = new Bonus();

                //Set Data
                bonus.setBonusType(bonusType);
                bonus.setTitle(bonusForm.getTitle());
                bonus.setPrice(bonusForm.getPrice());
                bonus.setDescription(bonusForm.getDescription());
            }
        } catch (DataIntegrityViolationException e) {
            //- Failure. Can not to create bonus -//
            response.setStatus( HttpStatus.CONFLICT.value() );
        }

        return null;
    }

    /**
     * Update already exist bonus.
     *
     * @param id         ID of Bonus
     * @param bonusForm  Updated data
     * @param response   Use for set HTTP status
     * @return           Updated bonus.
     */
    @RequestMapping( value = "/{id}", method = RequestMethod.PUT )
    @ResponseBody
    public Bonus updateAction(
            @PathVariable( "id" )
            Long id,

            @RequestBody
            @Valid
            BonusForm bonusForm,

            HttpServletResponse response
    ) {
        //- Search origin bonus -//
        Bonus bonusOrigin = this.bonusService.findById(id);

        if (bonusOrigin == null) {
            //- Failure. Bonus not found -//
            response.setStatus( HttpStatus.NOT_FOUND.value() );
            return null;
        }

        //- Update bonus -//
        try {
            //- Set new data -//
            bonusOrigin.setBonusType(bonusForm.getBonusType());
            bonusOrigin.setTitle(bonusForm.getTitle());
            bonusOrigin.setPrice(bonusForm.getPrice());
            bonusOrigin.setDescription(bonusForm.getDescription());

            //- Success. Return updated bonus -//
            return this.bonusService.update(bonusOrigin);
        } catch (DataIntegrityViolationException e) {
            //- Failure. Can not to create bonus -//
            response.setStatus( HttpStatus.FORBIDDEN.value() );
        }

        return null;
    }

    /**
     * Delete bonus.
     *
     * @param id          Id of Bonus.
     * @param response    Use for work with HTTP.
     */
    @RequestMapping( value = "/{id}", method = RequestMethod.DELETE )
    @ResponseBody
    public void deleteAction(
            @PathVariable( "id" )
            Long id,

            HttpServletResponse response
    ) {
        try {
            //- Try to delete bonus -//
            this.bonusService.delete(id);
        } catch (DataAccessException e) {
            // Failure. Bonus doesn't exists
            //- Set HTTP status -//
            response.setStatus( HttpStatus.NOT_FOUND.value() );
        }
    }
}
