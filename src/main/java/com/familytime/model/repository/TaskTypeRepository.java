/** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *
 *                                                                  *
 * @copyright 2016 (c), by Valentine
 *
 * @author <a href="mailto:valentunnamisnuk@gmail.com">Valentyn Namisnyk</a>
 *
 * @date 2016-08-06 11:22 :: 2016-08-06 11:41
 *
 * @address /Ukraine/Ivano-Frankivsk/Rozhniw
 *                                                                  *
 *///*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *

package com.familytime.model.repository;

import com.familytime.model.entity.Family;
import com.familytime.model.entity.TaskType;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Interface for work with persistence layout
 *
 * @version 1.0
 */
public interface TaskTypeRepository extends JpaRepository<TaskType, Long> {

    List<TaskType> findByFamily(Family family);
}
