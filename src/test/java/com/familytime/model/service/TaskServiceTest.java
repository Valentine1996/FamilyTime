package com.familytime.model.service;

import com.familytime.model.entity.Bonus;
import com.familytime.model.entity.Complexity;
import com.familytime.model.entity.Task;
import com.familytime.model.entity.TaskStatus;
import com.familytime.model.entity.TaskType;
import com.familytime.model.entity.User;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by valentyn on 3/14/17.
 */
public class TaskServiceTest extends AbstractServiceTest{

    @Autowired
    TaskService taskService;

    @Autowired
    BonusService bonusService;

    @Autowired
    ComplexityService complexityService;

    @Autowired
    UserService userService;

    @Autowired
    TaskTypeService taskTypeService;

    @Before
    public void tearUp() throws Exception {
        super.tearUp();
    }

    /**
     * Checking finding all tasks.
     */
    @Test
    public void testGettingAllTasks() {

        List<Task> result = taskService.findAll();

        Assert.assertEquals(3,result.size());
    }

    /**
     * Checking finding all open head tasks of performer.
     */
    @Test
    public void testGettingOpenHeadTasksByPerformer() {

        List<Task> result = taskService.findHeadTasksByPerformerAndStatus(1L, TaskStatus.OPEN);

        Assert.assertEquals(2,result.size());
    }

    /**
     * Checking finding all pending head tasks of performer.
     */
    @Test
    public void testPendingHeadTasksByPerformer() {

        List<Task> result = taskService.findHeadTasksByPerformerAndStatus(1L, TaskStatus.SOLVED);

        Assert.assertEquals(0,result.size());
    }

    /**
     * Test saving task.
     */
    @Test
    public void testSavingTask() {
        Bonus bonus = bonusService.findById(1L);
        Complexity complexity = complexityService.findById(1L);
        TaskType taskType = taskTypeService.findById(1L);
        User user = userService.find(1L);

        Task task = new Task(taskType,complexity,user,user,bonus,null,"testtest",
                new Integer("100"), LocalDateTime.now());

        Task createdTask = taskService.create(task);



    }
}
