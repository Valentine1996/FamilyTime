/** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *
 *                                                                  *
 * @copyright 2016 (c), by Valentine
 *
 * @author <a href="mailto:valentunnamisnuk@gmail.com">Valentyn Namisnyk</a>
 *
 * @date 2016-24-08 21:32:28 :: 2016-24-08 10:30:10
 *
 * @address /Ukraine/Ivano-Frankivsk/Rozhniw
 *                                                                   *
 *///*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *

package com.familytime.security.view.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Form for registration of a new users internally.
 *
 * @version 1.0
 */
public class InternalRegistrationForm {

    @NotBlank
    @Length( min = 2 , max = 32 )
    protected String lastName;

    @NotBlank
    protected String firstName;

    @NotBlank
    @Length( min = 2 , max = 32 )
    protected String middleName;

    @NotBlank
    @Length( min = 8, max = 32 )
    @Email
    protected String username;

    @NotBlank
    @Length( min = 8, max = 80 )
    protected String password;

    @NotNull
    protected LocalDate birthday;

    @NotNull
    protected Boolean gender;

    @NotNull
    protected Boolean isParent;

    @NotNull
    @NotEmpty
    @Size( max = 5 )
    protected String locale;

    /**
     * Default constructor.
     */
    public InternalRegistrationForm() {
    }

    /**
     * Constructor.
     *
     * @param lastName Last name
     * @param firstName First name
     * @param middleName Middle name
     * @param username Username
     * @param password Password
     * @param familyName Family name
     * @param birthday Birthday
     * @param gender Gender
     * @param locale Locale
     */
    public InternalRegistrationForm(String lastName, String firstName, String middleName,
                            String username, String password, String familyName,
                            LocalDate birthday, Boolean gender, String locale) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.gender = gender;
        this.locale = locale;
    }

    //- SECTION :: GET -//

    /**
     * Get user's last name.
     *
     * @return String User's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Get user's first name.
     *
     * @return String User's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get user's middle name.
     *
     * @return String User's middle name
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Get username.
     *
     * @return String Username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Get user's password.
     *
     * @return String User's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Get user's birthday.
     *
     * @return LocaleDate User's birthday
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * Get user's gender.
     *
     * @return Boolean User's gender
     */
    public Boolean getGender() {
        return gender;
    }

    /**
     * Check whether user is parent.
     *
     * @return Boolean Is parent
     */
    public Boolean getIsParent() {
        return isParent;
    }

    /**
     * Get user's locale.
     *
     * @return String User's locale
     */
    public String getLocale() {
        return locale;
    }

    //- SECTION :: SET -//

    /**
     * Set user's last name.
     *
     * @param lastName User's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Set user's first name.
     *
     * @param firstName User's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Set user's middle name.
     *
     * @param middleName User's middle name
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Set username.
     *
     * @param username Username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Set password.
     *
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Set user's birthday.
     *
     * @param birthday User's birthday
     */
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    /**
     * Set user's gender.
     *
     * @param gender User's gender
     */
    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    /**
     * Set user's parent status.
     *
     * @param isParent Parent TaskStatus
     */
    public void setIsParent(Boolean isParent) {
        this.isParent = isParent;
    }

    /**
     * Set user's locale.
     *
     * @param locale User's locale
     */
    public void setLocale(String locale) {
        this.locale = locale;
    }
}
