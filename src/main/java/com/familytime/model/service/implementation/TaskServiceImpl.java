/**
 * Created by Andrii Gaidychuk on 24.09.2016.
 */

package com.familytime.model.service.implementation;

import com.familytime.model.entity.Task;
import com.familytime.model.repository.TaskRepository;
import com.familytime.model.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of task service.
 *
 * @version 1.0
 */
@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    TaskRepository taskRepository;

    /**
     * Find task by ID.
     * @param id unique identificatos
     * @return Task found
     */
    @Override
    public Task findById(Long id) {
        return this.taskRepository.findOne(id);
    }

    /**
     * Find all tasks.
     * @return Lise < Task > list found tasks
     */
    @Override
    public List<Task> findAll() {
        return this.taskRepository.findAll();
    }

    /**
     * Create task.
     * @param task Task for create
     * @return Task created task
     */
    @Override
    public Task create(Task task) {
        return this.taskRepository.save(task);
    }

    /**
     * Update task.
     * @param task Task for update
     * @return Task updated task
     */
    @Override
    public Task update(Task task) {
        return this.taskRepository.save(task);
    }

    /**
     * Delete existed task.
     * @param id unique identificator task
     */
    @Override
    public void delete(Long id) {

    }
}
