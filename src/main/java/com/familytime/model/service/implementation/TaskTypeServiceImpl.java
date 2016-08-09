/** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *
 *                                                                  *
 * @copyright 2016 (c), by Valentine
 *
 * @author <a href="mailto:valentunnamisnuk@gmail.com">Valentyn Namisnyk</a>
 *
 * @date 2016-06-08 11:48 :: 2016-06-08 11:53
 *
 * @address /Ukraine/Ivano-Frankivsk/Rozhniw
 *                                                                  *
 *///*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *

package com.familytime.model.service.implementation;

import com.familytime.model.entity.TaskType;
import com.familytime.model.repository.TaskTypeRepository;
import com.familytime.model.service.TaskTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of TaskType service.
 *
 * @version 1.0
 */
@Service
public class TaskTypeServiceImpl implements TaskTypeService {

    @Autowired
    TaskTypeRepository taskTypeRepository;

    /**
     * Find task type by ID
     *
     * @param id Identification
     * @return TaskType found.
     */
    @Override
    public TaskType findById(Long id) {
        return this.taskTypeRepository.findOne(id);
    }

    
    /**
     * Find all existed task type.
     *
     * @return List < TaskType > List of task types.
     */
    @Override
    public List<TaskType> findAll() {
        return this.taskTypeRepository.findAll();
    }

    /**
     * Find task types for page.
     *
     * @param page  Number of page for return.
     * @param limit Count items per page.
     * @return List < TaskType > List of tasks.
     */
    @Override
    public List<TaskType> findAll(int page, int limit) {
        return taskTypeRepository.findAll(
            new PageRequest(
                Math.max( page - 1, 0 ),
                limit
            )
        )
            .getContent();
    }

    /**
     * Create new task type.
     *
     * @param taskType Data for creating new task type
     * @return TaskType created
     */
    @Override
    public TaskType create(TaskType taskType) {
        return this.taskTypeRepository.save(taskType);
    }

    /**
     * Updated existed task type.
     *
     * @param taskType Data for updated task type
     * @return TaskType updated
     */
    @Override
    public TaskType update(TaskType taskType) {
        return this.taskTypeRepository.save(taskType);
    }

    /**
     * Delete existed task type.
     *
     * @param id Identification of task type
     */
    @Override
    public void delete(Long id) {
        this.taskTypeRepository.delete(id);
    }
}
