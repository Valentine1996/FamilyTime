/** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *
 *                                                                  *
 * @copyright 2016 (c), by Valentine
 *
 * @author <a href="mailto:valentunnamisnuk@gmail.com">Valentyn Namisnyk</a>
 *
 * @date 2016-06-08 11:44 :: 2016-06-08 11:47
 *
 * @address /Ukraine/Ivano-Frankivsk/Rozhniw
 *                                                                  *
 *///*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *

package com.familytime.model.service;

import com.familytime.model.entity.Family;
import com.familytime.model.entity.TaskType;

import java.util.List;

public interface TaskTypeService {
    //- SECTION :: MAIN -//

    /**
     * Find task type by ID
     * @return TaskType found.
     */
    public TaskType findById(Long id);

    /**
     * Find all existed task type
     * @return List < TaskType > List of task types.
     */
    public List<TaskType> findAll();

    /**
     * Find task types for page.
     *
     * @param page Number of page for return.
     * @param limit Count items per page.
     *
     * @return List < TaskType > List of tasks.
     */
    public List<TaskType> findAll(int page, int limit);

    /**
     * Create new task type.
     * 
     * @param taskType Data for creating new task type
     * @return TaskType created
     */
    public TaskType create(TaskType taskType);

    /**
     * Updated existed task type.
     * 
     * @param taskType Data for updated task type
     * @return TaskType updated
     */
    public TaskType update(TaskType taskType);

    /**
     * Delete existed task type.
     *
     * @param id Identificator of task type
     */
    public void delete(Long id);
}
