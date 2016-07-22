/** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *
 *                                                                  *
 * @copyright 2016 (c), by Valentine
 *
 * @author <a href="mailto:valentunnamisnuk@gmail.com">Valentyn Namisnyk</a>
 *
 * @date 2016-07-16 11:20:59 :: 2016-07-16 11:52:37
 *
 * @address /Ukraine/Ivano-Frankivsk/Rozhniw
 *                                                                  *
 *///*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *

package com.familytime.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Class for reflect table Role from persistence layout.
 *
 * @version 1.0
 */
@SuppressWarnings( "serial" )
@Entity
@Table(
    name = "role"
    )
public class Role implements Serializable {
    /// *** Properties  *** ///
    @Id
    @GeneratedValue
    @Column( name = "id" )
    protected Long id;


    @NotNull
    @Column(name = "authority", unique = true)
    protected String authority;

    /**
     * Default constructor.
     */
    public Role() {
    }

    /**
     * Constructor.
     *
     * @param authority Role type
     */
    public Role(String authority) {
        this.authority = authority;
    }

    //- SECTION :: GET -//

    /**
     * Get ID of the authority.
     *
     * @return Long ID of family
     */
    public Long getId() {
        return id;
    }

    /**
     * Get authority.
     * 
     * @return String Authority
     */
    public String getAuthority() {
        return authority;
    }

    //- SECTION :: SET -//

    /**
     * Set ID of the family.
     *
     * @param id Id of the family
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Set authority.
     *
     * @param authority Authority type
     */
    public void setAuthority(String authority) {
        this.authority = authority;
        
    }
}
