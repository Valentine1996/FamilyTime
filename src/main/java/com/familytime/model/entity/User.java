/** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *
 *                                                                  *
 * @copyright 2016 (c), by Valentine
 *
 * @author <a href="mailto:valentunnamisnuk@gmail.com">Valentyn Namisnyk</a>
 *
 * @date 2016-17-08 10:44:24 :: 2016-18-08 16:55:20
 *
 * @address /Ukraine/Ivano-Frankivsk/Rozhniw
 *                                                                  *
 *///*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *

package com.familytime.model.entity;

import com.familytime.model.serializer.JsonDateSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
    name = "user"
    )
public class User implements Serializable {
    /// *** Properties  *** ///
    @Id
    @GeneratedValue
    @Column( name = "id" )
    protected Long id;


    @NotNull
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn( name = "family_id" )
    protected Family family;

    @NotNull
    @Length( min = 2 , max = 32)
    @Column(name = "first_name")
    protected String firstName;

    @NotNull
    @Length( min = 2 , max = 32)
    @Column(name = "last_name")
    protected String lastName;

    @NotNull
    @Length( min = 2 , max = 32)
    @Column(name = "middle_name")
    protected String middleName;

    @NotNull
    @Email
    @Length( min = 8, max = 32)
    @Column(name = "username", unique = true)
    protected String username;

    @NotNull
    @Length( min = 8, max = 80 )
    @Column(name = "password")
    protected String password;

    @JsonSerialize( using = JsonDateSerializer.class )
    @NotNull
    @Column(name = "birthday")
    protected LocalDate birthday;

    @NotNull
    @Column(name = "gender")
    protected Boolean gender;

    @NotBlank()
    @Length(max = 5)
    @Column(name = "locale", length = 5)
    protected String locale;

    @NotNull
    @Column(name = "isParent")
    protected Boolean isParent;

    @NotNull
    @Column(name = "isActive", nullable = false)
    protected Boolean isActive;

    @ManyToMany( fetch = FetchType.EAGER )
    @JoinTable(
        name = "user_role",
        uniqueConstraints = @UniqueConstraint(
            columnNames = {
                "user_id",
                "role_id"
            }
        ),
        joinColumns = {
            @JoinColumn(
                name = "user_id",
                nullable = false,
                unique = false,
                updatable = false
                )
            },
        inverseJoinColumns = {
            @JoinColumn(
                name = "role_id",
                unique = false,
                nullable = false,
                updatable = false
                )
            }
        )
    protected List<Role> roles = new ArrayList<>();

    /**
     * Default constructor.
     */
    public User() {
    }

    /**
     * Constructor.
     *
     * @param family User's family
     * @param firstName User's first name
     * @param lastName User's last name
     * @param middleName User's middle name
     * @param username Username
     * @param password User's password
     * @param birthday User's birthday
     * @param gender User's gender
     * @param locale User's locale
     * @param isParent User's parent status
     * @param isActive User's status
     * @param roles Set of the user's roles
     */
    public User(Family family, String firstName, String lastName, String middleName,
                String username, String password, LocalDate birthday,
                Boolean gender, String locale, Boolean isParent, Boolean isActive,
                List<Role> roles) {
        this.family = family;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.gender = gender;
        this.locale = locale;
        this.isParent = isParent;
        this.isActive = isActive;
        this.roles = roles;
    }
    //- SECTION :: GET -//

    /**
     * Get ID of the user.
     *
     * @return Long ID of the user
     */
    public Long getId() {
        return id;
    }

    /**
     * Get user's family.
     *
     * @return Family User's family
     */
    public Family getFamily() {
        return family;
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
     * Get user's last name.
     *
     * @return String User's last name
     */
    public String getLastName() {
        return lastName;
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
     * @return LocaleLocalDate User's birthday
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
     * Get user's locale.
     *
     * @return String User's locale
     */
    public String getLocale() {
        return locale;
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
     * Get user's status.
     *
     * @return Boolean User's status
     */
    public Boolean getIsActive() {
        return isActive;
    }

    /**
     * Get user's roles.
     *
     * @return List List of the roles.
     */
    public List<Role> getRoles() {
        return roles;
    }

    //- SECTION :: SET -//

    /**
     * Set user's ID.
     *
     * @param id ID of the family
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Set user's family.
     *
     * @param family User's family
     */
    public void setFamily(Family family) {
        this.family = family;
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
     * Set user's last name.
     *
     * @param lastName User's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
     * Set user's locale.
     *
     * @param locale User's locale
     */
    public void setLocale(String locale) {
        this.locale = locale;
    }

    /**
     * Set user's parent status.
     *
     * @param isParent Parent Status
     */
    public void setIsParent(Boolean isParent) {
        this.isParent = isParent;
    }

    /**
     * Set user's status.
     *
     * @param isActive User's status
     */
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * Set user's roles.
     *
     * @param roles List of the user's roles
     */
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}