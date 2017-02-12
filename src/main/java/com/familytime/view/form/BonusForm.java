/**
 * Created by Andrii Gaidychuk on 15.09.2016.
 */

package com.familytime.view.form;

import com.familytime.model.entity.BonusType;

import org.hibernate.validator.constraints.Length;

/**
 * Form for bonus type.
 *
 * @version 1.0
 */
public class BonusForm {
    /// *** Properties  *** ///

    protected BonusType bonusType;

    @Length(max = 64)
    protected String title;

    protected String description;

    protected Integer price;

    /**
     * Default constructor.
     */
    public BonusForm() {
    }

    /**
     * Constructor.
     *
     * @param bonusType Bonus's type
     * @param price Bonus's price
     */
    public BonusForm(BonusType bonusType, Integer price) {
        this.bonusType = bonusType;
        this.price = price;
    }

    /**
     * Constructor.
     *
     * @param bonusType Bonus's type
     * @param title Bonu's title
     * @param price Bonus's price
     * @param description Bonus's description
     */
    public BonusForm(BonusType bonusType, String title, Integer price, String description) {
        this.bonusType = bonusType;
        this.title = title;
        this.price = price;
        this.description = description;
    }

    //- SECTION :: GET -//

    /**
     * Get Type of the bonus.
     * @return bonusType Type of the bonus
     */
    public BonusType getBonusType() {
        return bonusType;
    }

    /**
     * Get Title of the bonus.
     * @return String Title of the bonus
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get Description of the bonus.
     * @return String Description of the Bonus
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get price of the bonus.
     * @return Integer Price of the Bonus
     */
    public Integer getPrice() {
        return price;
    }

    //- SECTION :: SET -//

    /**
     * Set Type of the bonus.
     *
     * @param bonusType Type of the bonus
     */
    public void setBonusType(BonusType bonusType) {
        this.bonusType = bonusType;
    }

    /**
     * Set Title of the bonus.
     *
     * @param title Title of the bonus
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Set Description of the bonus.
     *
     * @param description  of the bonus
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Set Price of the bonus.
     *
     * @param price Price of the bonus
     */
    public void setPrice(Integer price) {
        this.price = price;
    }
}
