/**
 * Created by Andrii Gaidychuk on 25.07.2016.
 */

package com.familytime.model.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Class for reflect table bonus_type from persistence layout
 *
 * @version 1.0
 */
@SuppressWarnings( "serial" )
@Entity
@Table( name = "bonus_type")
public class BonusType {

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
    @Column( name = "short_name")
    @Length(max = 16)
    protected String short_name;

    @Column( name = "description")
    protected String description;

    @NotNull
    @Column( name = "icon_name")
    @Length( max = 16)
    protected String icon_name;

    /**
     * Default constructor.
     */
    public BonusType() {
    }

    /**
     * Constructor.
     *
     * @param family Bonus's family
     * @param short_name Bonus's short name
     * @param icon_name Bonus's icon name
     */
    public BonusType(Family family, String short_name, String icon_name) {
        this.family = family;
        this.short_name = short_name;
        this.icon_name = icon_name;
    }

    /**
     * Constructor.
     *
     * @param family Bonus's family
     * @param short_name Bonus's short name
     * @param description Bonus's description
     * @param icon_name Bonus's icon name
     */
    public BonusType(Family family, String short_name, String description, String icon_name) {
        this.family = family;
        this.short_name = short_name;
        this.description = description;
        this.icon_name = icon_name;
    }

    //- SECTION :: GET -//

    /**
     * Get ID of the bonus_type.
     * @return Long ID of the Bonuses
     */
    public Long getId() {
        return id;
    }

    /**
     * Get family of the bonus type.
     * @return Family Bonus's family
     */
    public Family getFamily() {
        return family;
    }

    /**
     * Get short name of the bonus type.
     * @return String Bonus's short name
     */
    public String getShort_name() {
        return short_name;
    }

    /**
     * Get description of the bonus type.
     * @return String Bonus's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get icon name of the bonus type.
     * @return String Bonus's icon name
     */
    public String getIcon_name() {
        return icon_name;
    }


    //- SECTION :: SET -//

    /**
     * Set ID of the bonus type
     *
     * @param id ID of the bonus type
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Set family of the bonus type.
     *
     * @param family ID of the bonus type
     */
    public void setFamily(Family family) {
        this.family = family;
    }

    /**
     * Set short name of the bonus type.
     *
     * @param short_name of the bonus type
     */
    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    /**
     * Set description of the bonus type.
     *
     * @param description of the bonus type
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Set icon name of the bonus type.
     *
     * @param icon_name of the bonus type
     */
    public void setIcon_name(String icon_name) {
        this.icon_name = icon_name;
    }
}
