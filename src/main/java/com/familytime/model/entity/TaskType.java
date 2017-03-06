/** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *
 *                                                                  *
 * @copyright 2016 (c), by Valentine
 *
 * @author <a href="mailto:valentunnamisnuk@gmail.com">Valentyn Namisnyk</a>
 *
 * @date 2016-08-06 11:33 :: 2016-08-06 11::37
 *
 * @address /Ukraine/Ivano-Frankivsk/Rozhniw
 *                                                                  *
 *///*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *

package com.familytime.model.entity;

import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 * Class for reflect table user from persistence layout
 *
 * @version 1.0
 */
@Entity
@Table(
        name = "task_type",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {
                                "family_id",
                                "shortName"
                        }
                )
        })
public class TaskType implements Serializable {
    /// *** Properties  *** ///
    @Id
    @GeneratedValue
    @Column( name = "id")
    protected Long id;

    @NotNull
    @ManyToOne
    @JoinColumn( name = "family_id")
    protected Family family;

    @NotNull
    @Column( name = "shortName")
    @Length(max = 16)
    protected String shortName;

    @Column( name = "description")
    protected String description;

    /**
     * Default constructor.
     */
    public TaskType() {
    }

    /**
     * Constructor.
     *
     * @param family User's family
     * @param shortName Task's short name
     */
    public TaskType(Family family, String shortName) {
        this.family = family;
        this.shortName = shortName;
    }

    /**
     * Constructor.
     *
     * @param family User's family
     * @param shortName Task's short name
     * @param description Task's description
     */
    public TaskType(Family family, String shortName, String description) {
        this.family = family;
        this.shortName = shortName;
        this.description = description;
    }

    //- SECTION :: GET -//

    /**
     * Get ID of the task_type.
     * @return Long ID of the task
     */
    public Long getId() {
        return id;
    }

    /**
     * Get family of the task type.
     * @return Family Task's family
     */
    public Family getFamily() {
        return family;
    }

    /**
     * Get short name of the task type.
     * @return String Task's short name
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * Get description of the task type.
     * @return String Tasks's description
     */
    public String getDescription() {
        return description;
    }

    //- SECTION :: SET -//

    /**
     * Set ID of the task type.
     *
     * @param id ID of the task type
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Set family of the task type.
     *
     * @param family ID of the task type
     */
    public void setFamily(Family family) {
        this.family = family;
    }

    /**
     * Set short name of the task type.
     *
     * @param shortName of the task type
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * Set description of the task type.
     *
     * @param description of the task type
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
