/**
 * Created by Andrii Gaidychuk on 25.07.2016.
 */

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
import javax.validation.constraints.NotNull;


/**
 * Class for reflect table bonus_type from persistence layout
 *
 * @version 1.0
 */
@SuppressWarnings( "serial" )
@Entity
@Table( name = "bonus_type")
public class BonusType implements Serializable {

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

    @NotNull
    @Column( name = "iconName")
    @Length( max = 16)
    protected String iconName;

    /**
     * Default constructor.
     */
    public BonusType() {
    }

    /**
     * Constructor.
     *
     * @param family Bonus's family
     * @param shortName Bonus's short name
     * @param iconName Bonus's icon name
     */
    public BonusType(Family family, String shortName, String iconName) {
        this.family = family;
        this.shortName = shortName;
        this.iconName = iconName;
    }

    /**
     * Constructor.
     *
     * @param family Bonus's family
     * @param shortName Bonus's short name
     * @param description Bonus's description
     * @param iconName Bonus's icon name
     */
    public BonusType(Family family, String shortName, String description, String iconName) {
        this.family = family;
        this.shortName = shortName;
        this.description = description;
        this.iconName = iconName;
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
    public String getShortName() {
        return shortName;
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
    public String getIconName() {
        return iconName;
    }

    //- SECTION :: SET -//

    /**
     * Set ID of the bonus type.
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
     * @param shortName of the bonus type
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
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
     * @param iconName of the bonus type
     */
    public void setIconName(String iconName) {
        this.iconName = iconName;
    }
}
