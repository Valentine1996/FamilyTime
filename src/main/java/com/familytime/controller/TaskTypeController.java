package com.familytime.controller;

import static org.springframework.util.Assert.notNull;

import com.familytime.model.entity.Family;
import com.familytime.model.entity.TaskType;
import com.familytime.model.service.SecurityService;
import com.familytime.model.service.TaskTypeService;
import com.familytime.view.form.TaskTypeForm;

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
 * Controller for task types.
 *
 * @version 1.0
 */
@RestController
@RequestMapping( value = "/taskType" )
public class TaskTypeController {
    /// *** Properties  *** ///
    /**
     * Service for work with task types.
     */
    @Autowired
    protected TaskTypeService taskTypeService;

    /**
     * Service for getting data from logged user.
     */
    @Autowired
    protected SecurityService securityService;

    /// *** Methods     *** ///

    /**
     * Get list of task types.
     *
     * @return List of task types.
     */
    @RequestMapping( method = RequestMethod.GET )
    @ResponseStatus( HttpStatus.OK )
    @ResponseBody
    public List<TaskType> findAll() {

        //- Get user's family -/
        Family usersFamily = securityService.getFamilyOfLoggedUser();

        return this.taskTypeService.findByFamily(usersFamily);
    }

    /**
     * Create a new task type.
     *
     * @param taskTypeForm          Form with input.
     * @param response              Use for work with HTTP.
     *
     * @return Created task type.
     */
    @RequestMapping( method = RequestMethod.POST )
    @ResponseBody
    public TaskType createAction(
            @RequestBody
            @Valid
            TaskTypeForm taskTypeForm,

            HttpServletResponse response
    ) {
        try {
            //- Set HTTP status -//
            response.setStatus( HttpStatus.CREATED.value() );

            //- Get user's family -/
            Family usersFamily = securityService.getFamilyOfLoggedUser();

            if (usersFamily == null) {
                //- Failure. Can not to create task type -//
                response.setStatus( HttpStatus.CONFLICT.value() );
            } else {
                //Create new task type
                TaskType taskType = new TaskType();
                //Set data
                //- Set user's family -//
                taskType.setFamily(usersFamily);
                taskType.setShortName(taskTypeForm.getShortName());
                taskType.setDescription(taskTypeForm.getDescription());

                //- Success. Return created task type -//
                return this.taskTypeService.create(taskType);
            }
        } catch ( DataIntegrityViolationException e ) {
            //- Failure. Can not create task type -//
            response.setStatus( HttpStatus.CONFLICT.value() );
        }
        return null;
    }

    /**
     * Get task type by id.
     *
     * @param id          Id of task type.
     * @param response    Use for work with HTTP.
     *
     * @return Found task type.
     */
    @RequestMapping( value = "/{id}", method = RequestMethod.GET )
    @ResponseBody
    public TaskType find(
            @PathVariable( "id" )
            Long id,

            HttpServletResponse response
    ) {
        try {
            //- Search requested task type -//
            TaskType taskType = this.taskTypeService.findById( id );

            //- Check if task type was found -//
            notNull( taskType );

            return taskType;
        } catch ( IllegalArgumentException e ) {
            //- Error. Cannot find this task type -//
            response.setStatus( HttpServletResponse.SC_NOT_FOUND );
        }

        return null;
    }

    /**
     * Update already existed task type.
     *
     * @param id                 ID of task type
     * @param taskTypeForm     Updated data
     * @param response           Use for set HTTP status
     *
     * @return Updated task type.
     */
    @RequestMapping( value = "/{id}", method = RequestMethod.PUT )
    @ResponseBody
    public TaskType updateAction(
            @PathVariable( "id" )
                    Long id,

            @RequestBody
            @Valid
            TaskTypeForm taskTypeForm,

            HttpServletResponse response
    ) {
        //- Search origin task type -//
        TaskType taskTypeOrigin = this.taskTypeService.findById( id );

        if ( taskTypeOrigin == null ) {
            //- Failure. Task type not found -//
            response.setStatus( HttpStatus.NOT_FOUND.value() );
            return null;
        }

        //- Update task type -//
        try {
            //- Set new data -//
            taskTypeOrigin.setShortName( taskTypeForm.getShortName());
            taskTypeOrigin.setDescription( taskTypeForm.getDescription());

            //- Success. Return updated taskType -//
            return this.taskTypeService.update(taskTypeOrigin);
        } catch ( DataIntegrityViolationException e ) {
            //- Failure. Can not create task type -//
            response.setStatus( HttpStatus.FORBIDDEN.value() );
        }

        return null;
    }

    /**
     * Delete task type.
     *
     * @param id          Id of task type.
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
            //- Try to delete task type -//
            this.taskTypeService.delete( id );
        } catch ( DataAccessException e ) {
            // Failure. Task type doesn't exists
            //- Set HTTP status -//
            response.setStatus( HttpStatus.NOT_FOUND.value() );
        }
    }
}
