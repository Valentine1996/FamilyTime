/** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *
 *                                                                  *
 * @copyright 2016 (c), by Valentine
 *
 * @author <a href="mailto:valentunnamisnuk@gmail.com">Valentyn Namisnyk</a>
 *
 * @date 2016-18-07 19:02:50 :: 2016-18-07 19:05:15
 *
 * @address /Ukraine/Ivano-Frankivsk/Rozhniw
 *                                                                  *
 *///*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *

package com.familytime.model.service.implementation;

import com.familytime.model.entity.User;
import com.familytime.model.repository.UserRepository;
import com.familytime.model.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of user service.
 *
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    /**
     * Find users for page.
     *
     * @return List < User > List of users.
     */
    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    /**
     * Create the new user.
     *
     * @param user Data for creating new user
     * @return Role Created user
     */
    @Override
    public User create(User user) {
        return this.userRepository.save(user);
    }

    /**
     * Find user by id.
     *
     * @param id Unique identificator
     * @return User Found
     */
    @Override
    public User find(Long id) {
        return this.userRepository.findOne(id);
    }

    /**
     * Update the existed user.
     *
     * @param user User for update
     * @return User Updated user
     */
    @Override
    public User update(User user) {
        return this.userRepository.save(user);
    }

    /**
     * Delete the existed user.
     *
     * @param id Identificator of user
     */
    @Override
    public void delete(Long id) {
        this.userRepository.delete(id);
    }
}
