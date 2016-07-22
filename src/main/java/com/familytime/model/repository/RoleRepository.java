/** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *
 *                                                                  *
 * @copyright 2016 (c), by Valentine
 *
 * @author <a href="mailto:valentunnamisnuk@gmail.com">Valentyn Namisnyk</a>
 *
 * @date 2016-18-08 18:24:50 :: 2016-18-08 18:30:50
 *
 * @address /Ukraine/Ivano-Frankivsk/Rozhniw
 *                                                                  *
 *///*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *

package com.familytime.model.repository;

import com.familytime.model.entity.Role;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface for work with persistence layout
 *
 * @version 1.0
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}