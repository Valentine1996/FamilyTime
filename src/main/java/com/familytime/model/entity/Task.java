/**
 * Created by Andrii Gaidychuk on 18.09.2016.
 */

package com.familytime.model.entity;

import com.familytime.model.serializer.JsonDataTimeSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Class for reflect table parentTask from persistence layout
 *
 * @version 1.0
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "task")
public class Task implements Serializable {

    /// *** Properties  *** ///

    @Id
    @GeneratedValue
    @Column(name = "id")
    protected Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "task_type_id")
    protected TaskType taskType;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "complexity_id")
    protected Complexity complexity;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "creator_id")
    protected User creator;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "performer_id")
    protected User performer;

    @ManyToOne
    @JoinColumn(name = "bonus_id")
    protected Bonus bonus;

    @NotNull
    @Column(name = "has_subtasks")
    @Value("false")
    protected Boolean hasSubtasks;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    protected Task parentTask;

    @Column(name = "step")
    protected Integer step;

    @NotBlank
    @Column(name = "description")
    protected String description;

    @NotNull
    @Column(name = "prize")
    protected Integer prize;

    @NotNull
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    protected TaskStatus status;

    @NotNull
    @JsonSerialize(using = JsonDataTimeSerializer.class)
    @Column(name = "close_to")
    protected LocalDateTime closeTo;

    @JsonSerialize(using = JsonDataTimeSerializer.class)
    @Column(name = "created_at")
    protected LocalDateTime createdAt;

    @PrePersist
    public void perStore() {
        this.createdAt = LocalDateTime.now();
    }

    /**
     * Default constructor.
     */
    public Task() {
    }

    /**
     * Constructor.
     *
     * @param taskType Task's type
     * @param complexity Task's complexity
     * @param creator Task's creator
     * @param performer Task's performer
     * @param bonus Task's bonus
     * @param step Task's step
     * @param description Task's description
     * @param prize Task's prize
     * @param closeTo Task's close date
     */
    public Task(TaskType taskType, Complexity complexity, User creator, User performer,
                Bonus bonus, Integer step, String description,
                Integer prize, LocalDateTime closeTo) {

        this.taskType = taskType;
        this.complexity = complexity;
        this.creator = creator;
        this.performer = performer;
        this.bonus = bonus;
        this.step = step;
        this.description = description;
        this.prize = prize;
        this.closeTo = closeTo;
        this.hasSubtasks = false;
        this.status = TaskStatus.OPEN;
    }

    /**
     * Constructor.
     *
     * @param taskType Task's type
     * @param complexity Task's complexity
     * @param creator Task's creator
     * @param performer Task's performer
     * @param bonus Task's bonus
     * @param step Task's step
     * @param description Task's description
     * @param prize Task's prize
     * @param closeTo Task's close date
     * @param parentTask Task's parent
     */
    public Task(TaskType taskType, Complexity complexity, User creator, User performer,
                Bonus bonus, Integer step, String description, Integer prize, LocalDateTime closeTo,
                Task parentTask) {

        this.taskType = taskType;
        this.complexity = complexity;
        this.creator = creator;
        this.performer = performer;
        this.bonus = bonus;
        this.step = step;
        this.description = description;
        this.prize = prize;
        this.closeTo = closeTo;
        this.hasSubtasks = true;
        this.parentTask = parentTask;
        this.status = TaskStatus.OPEN;
    }

    //- SECTION :: GET -//

    /**
     * Get ID of the taks.
     * @return Long ID of the Task
     */
    public Long getId() {
        return id;
    }

    /**
     * Get Type of the taks.
     * @return TaksType of the Task
     */
    public TaskType getTaskType() {
        return taskType;
    }

    /**
     * Get Complexity of the parentTask.
     * @return Complexity of the Task
     */
    public Complexity getComplexity() {
        return complexity;
    }

    /**
     * Get Creator of the parentTask.
     * @return User that created Task
     */
    public User getCreator() {
        return creator;
    }

    /**
     * Get Perfomer of the parentTask.
     * @return User that perform Task
     */
    public User getPerformer() {
        return performer;
    }

    /**
     * Get Bonus of the parentTask.
     * @return Bonus of the Task
     */
    public Bonus getBonus() {
        return bonus;
    }

    /**
     * Get Flag if parentTask has sub tasks.
     * @return Boolean 'true' if parentTask has sub tasks
     */
    public Boolean getHasSubtasks() {
        return hasSubtasks;
    }

    /**
     * Get Parent parentTask of the parentTask.
     * @return Task which is parent for the current parentTask
     */
    public Task getParentTask() {
        return parentTask;
    }

    /**
     * Get Step of the parentTask.
     * @return Integer value step of the current parentTask
     */
    public Integer getStep() {
        return step;
    }

    /**
     * Get Description of the parentTask.
     * @return String description of the parentTask
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get Prize of the parentTask.
     * @return Integer prize of the parentTask
     */
    public Integer getPrize() {
        return prize;
    }

    /**
     * Get Close date of the parentTask.
     * @return LocalDateTime close date of the parentTask
     */
    public LocalDateTime getCloseTo() {
        return closeTo;
    }

    /**
     * Get Create date of the parentTask.
     * @return LocalDateTime create date of the parentTask
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Get parentTask's status.
     * @return parentTask's status
     */
    public TaskStatus getStatus() {
        return status;
    }

    //- SECTION :: SET -//

    /**
     * Set ID for parentTask.
     *
     * @param id ID of the parentTask
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Set Task Type for parentTask.
     *
     * @param taskType parentTask type of the parentTask
     */
    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    /**
     * Set Complexity for parentTask.
     *
     * @param complexity complexity of the parentTask
     */
    public void setComplexity(Complexity complexity) {
        this.complexity = complexity;
    }

    /**
     * Set Creator for parentTask.
     *
     * @param creator User creator of the parentTask
     */
    public void setCreator(User creator) {
        this.creator = creator;
    }

    /**
     * Set Performer for parentTask.
     *
     * @param performer User performer of the parentTask
     */
    public void setPerformer(User performer) {
        this.performer = performer;
    }

    /**
     * Set Bonus for parentTask.
     *
     * @param bonus Bonus of the parentTask
     */
    public void setBonus(Bonus bonus) {
        this.bonus = bonus;
    }

    /**
     * Set Flag if parentTask has sub tasks.
     *
     * @param hasSubtasks Boolean flag of the parentTask
     */
    public void setHasSubtasks(Boolean hasSubtasks) {
        this.hasSubtasks = hasSubtasks;
    }

    /**
     * Set Parent parentTask.
     *
     * @param parentTask parent Task
     */
    public void setParentTask(Task parentTask) {
        this.parentTask = parentTask;
    }

    /**
     * Set Step for parentTask.
     *
     * @param step Step of the parentTask
     */
    public void setStep(Integer step) {
        this.step = step;
    }

    /**
     * Set Description for parentTask.
     *
     * @param description of the parentTask
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Set Prize for parentTask.
     *
     * @param prize of the parentTask
     */
    public void setPrize(Integer prize) {
        this.prize = prize;
    }

    /**
     * Set Close date for parentTask.
     *
     * @param closeTo of the parentTask
     */
    public void setCloseTo(LocalDateTime closeTo) {
        this.closeTo = closeTo;
    }

    /**
     * Set Create date for parentTask.
     *
     * @param createdAt of the parentTask
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * set parentTask's status.
     * @param status parentTask's status
     */
    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
