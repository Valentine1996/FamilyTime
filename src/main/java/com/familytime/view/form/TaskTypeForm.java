package com.familytime.view.form;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Form for task type.
 *
 * @version 1.0
 */
public class TaskTypeForm {

    @NotBlank
    @Length(max = 16)
    protected String shortName;

    @NotBlank
    protected String description;

    /**
     * Default constructor.
     */
    public TaskTypeForm() {
    }

    /**
     * Constructor.
     *
     * @param shortName Task's type short name
     * @param description Task's type description
     */
    public TaskTypeForm(String shortName, String description) {
        this.shortName = shortName;
        this.description = description;
    }

    //- SECTION :: GET -//

    /**
     * Get short name of task type.
     *
     * @return String Task type.
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * Get description of task type.
     *
     * @return String Task's type description.
     */
    public String getDescription() {
        return description;
    }

    //- SECTION :: SET -//

    /**
     * Set short name of the task type.
     *
     * @param shortName of the task type.
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * Set description of the task type.
     *
     * @param description of the task type.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
