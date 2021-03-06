package com.familytime.view.form;

import org.hibernate.validator.constraints.NotBlank;

import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

/**
 * Form for Task.
 *
 * @version 1.0
 */
public class TaskForm {
    /// *** Properties  *** ///

    @NotNull
    protected Long taskTypeId;

    @NotNull
    protected Long complexityId;

    @NotNull
    protected Long performerId;

    protected Long bonusId;

    protected Long taskId;

    @NotBlank
    protected String description;

    @NotNull
    protected Integer prize;

    @NotNull
    protected LocalDateTime closeTo;

    protected String status;

    /**
     * Default constructor.
     */
    public TaskForm() {
    }

    /**
     * Constructor.
     * @param taskTypeId Task's types
     * @param complexityId Task's complexity
     * @param performerId Task's performer
     * @param bonusId Task's bonus
     * @param taskId Parent parentTask
     * @param description Task's description
     * @param prize Task's prize
     * @param closeTo Close to date
     */
    public TaskForm(Long taskTypeId, Long complexityId, Long performerId, Long bonusId, Long taskId,
                    String description, Integer prize, LocalDateTime closeTo) {
        this.taskTypeId = taskTypeId;
        this.complexityId = complexityId;
        this.performerId = performerId;
        this.bonusId = bonusId;
        this.taskId = taskId;
        this.description = description;
        this.prize = prize;
        this.closeTo = closeTo;
    }

    //- SECTION :: GET -//


    /**
     * Get task type ID.
     * @return Long - ID of the parentTask type.
     */
    public Long getTaskTypeId() {
        return taskTypeId;
    }

    /**
     * Get task ID.
     * @return Long - ID of the complexity.
     */
    public Long getComplexityId() {
        return complexityId;
    }

    /**
     * Get task ID.
     * @return Long - ID of the performer.
     */
    public Long getPerformerId() {
        return performerId;
    }

    /**
     * Get task ID.
     * @return Long - ID of the bonus.
     */
    public Long getBonusId() {
        return bonusId;
    }

    /**
     * Get task ID.
     * @return Long - parentTask ID.
     */
    public Long getTaskId() {
        return taskId;
    }

    /**
     * Get task's description.
     * @return String - description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get task's price.
     * @return Integer - price.
     */
    public Integer getPrize() {
        return prize;
    }

    /**
     * Get Close to date.
     * @return LocalDateTime - Close to date.
     */
    public LocalDateTime getCloseTo() {
        return closeTo;
    }

    /**
     * Get task's status.
     * @return String - task's status.
     */
    public String getStatus() {
        return status;
    }

    //- SECTION :: SET -//


    /**
     * Set task type ID.
     * @param taskTypeId - task type ID.
     */
    public void setTaskTypeId(Long taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    /**
     * Set complexity ID.
     * @param complexityId - complexity ID.
     */
    public void setComplexityId(Long complexityId) {
        this.complexityId = complexityId;
    }

    /**
     * Set performer ID.
     * @param performerId - performer ID.
     */
    public void setPerformerId(Long performerId) {
        this.performerId = performerId;
    }

    /**
     * Set bonus id.
     * @param bonusId - bonus id.
     */
    public void setBonusId(Long bonusId) {
        this.bonusId = bonusId;
    }

    /**
     * Set parentTask id.
     * @param taskId - parentTask id.
     */
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    /**
     * Set task's description.
     * @param description - task's description.
     * */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Set task's prize.
     * @param prize - task's prize.
     */
    public void setPrize(Integer prize) {
        this.prize = prize;
    }

    /**
     * Set Close to date.
     * @param closeTo - Close to date.
     */
    public void setCloseTo(LocalDateTime closeTo) {
        this.closeTo = closeTo;
    }

    /**
     * Set task's status
     *
     * @param status - Task's status.
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
