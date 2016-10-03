/**
 * Created by Andrii Gaidychuk on 24.09.2016.
 */

package com.familytime.model.service;

import com.familytime.model.entity.Task;

import java.util.List;

public interface TaskService {

    //- SECTION :: MAIN -//

    /**
     * Find Task by ID.
     * @return Task found
     */
    public Task findById(Long id);

    /**
     * Find all existed tasks.
     * @return List < Task > List of tasks
     */
    public List<Task> findAll();

    /**
     * Create new task.
     * @param task Data for creating new task
     * @return Task created
     */
    public Task create(Task task);

    /**
     * Updated existed task.
     * @param task Data for updated task
     * @return Task updated
     */
    public Task update(Task task);

    /**
     * Delete existed task.
     * @param id identificator for delete task
     */
    public void delete(Long id);
}
