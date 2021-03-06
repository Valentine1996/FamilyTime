/** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *
 *                                                                  *
 * @copyright 2016 (c), by Valentine
 *
 * @author <a href="mailto:valentunnamisnuk@gmail.com">Valentyn Namisnyk</a>
 *
 * @date 2016-07-10 15:00:59 :: 2014-07-08 12:15:37
 *
 * @address /Ukraine/Ivano-Frankivsk/Rozhniw
 *                                                                  *
 *///*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *

package com.familytime.model.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Class for reflect table Family from persistence layout.
 *
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(
    name = "family"
    )
public class Family implements Serializable {
    /// *** Properties  *** ///
    @Id
    @GeneratedValue
    @Column( name = "id" )
    protected Long id;

    @NotNull
    @NotEmpty
    @Length( max = 32 )
    @Column( name = "name", unique = true)
    protected String name;

    /**
     * Default constructor.
     */
    public Family() {
    }

    /**
     * Constructor.
     *
     * @param name Name of the family
     */
    public Family(String name) {
        this.name = name;
    }

    //- SECTION :: GET -//
    
    /**
     * Get ID of the family.
     *
     * @return Long ID of the family
     */
    public Long getId() {
        return id;
    }

    /**
     * Get name of the family.
     *
     * @return String accounting system
     */
    public String getName() {
        return name;
    }

    //- SECTION :: SET -//
    
    /**
     * Set ID of the family.
     *
     * @param id ID of the family
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Set name of the family.
     *
     * @param name Name of the family
     */
    public void setName(String name) {
        this.name = name;
    }
}
