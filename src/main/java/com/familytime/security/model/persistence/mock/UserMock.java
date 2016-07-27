/** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *
 *                                                                  *
 * @copyright 2016 (c), by Valentine
 *
 * @author <a href="mailto:valentunnamisnuk@gmail.com">Valentyn Namisnyk</a>
 *
 * @date 2016-25-08 20:15:16 ::
 *
 * @address /Ukraine/Ivano-Frankivsk/Rozhniw
 *                                                                   *
 *///*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***

package com.familytime.security.model.persistence.mock;

import com.familytime.model.entity.Family;
import com.familytime.model.entity.Role;
import com.familytime.model.entity.User;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Mock for persistence layout of users.
 *
 * @version 1.0
 * @see User
 */
public class UserMock {

    /**
     * Mock for create.
     *
     * @return User.
     */
    public static User createParent() {

        User user = new User(
            FamilyMock.create(),
            "Ivan",
            "Ivanenko",
            "Ivanovuch@gmail.com",
            "Ivan2000",
            "te$t",
            LocalDate.of(2000,2,2),
            true, //gender
            "uk_UA",
            true, // parent status
            true, // gender
            new ArrayList<Role>() {
                {
                    add(
                        new Role("PARENT")
                    );
                }
            }
        );
        user.setId(1L);

        return user;
    }
}
