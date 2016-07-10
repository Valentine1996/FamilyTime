/// *** *** Model :: Entity :: Family *** *** *** *** *** *** *** ///

/** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *
 *                                                                  *
 * @copyright 2016 (c), by Valentine
 *
 * @author Valentyn Namisnyk <valentunnamisnuk@gmail.com>
 *
 * @date 2016-07-10 12:00:59 :: 2014-07-08 12:24:37
 *
 * @address /Ukraine/Ivano-Frankivsk/Rozhniw
 *                                                                  *
 *///*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *

/// *** Code    *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ///
package com.familytime.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

/**
 * Class for reflect table family from persistence layout
 *
 * @version 1.0
 */
@SuppressWarnings( "serial" )
@Entity
@Table(
    name = "family"
)
public class Family implements Serializable {
    @Id
    @GeneratedValue
    @Column( name = "id" )
    protected Long id;

    @NotNull
    @NotEmpty
    @Length( max = 32 )
    @Column( name = "name", length = 16 , unique = true)
    protected String name;

    /**
     * Default constructor
     */
    public Family() {
    }


    /**
     * Constructor
     *
     * @param name
     */
    public Family(String name) {
        this.name = name;
    }

    //- SECTION :: GET -//
    
    /**
     * Get ID of family
     *
     * @return Long ID of family
     */
    public Long getId() {
        return id;
    }

    /**
     * Get name of family
     *
     * @return String accounting system
     */
    public String getName() {
        return name;
    }

    //- SECTION :: SET -//
    /**
     * Set ID of family
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Set name of family
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}
