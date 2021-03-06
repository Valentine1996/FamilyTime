/** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *
 *                                                                  *
 * @copyright 2016 (c), by Valentine
 *
 * @author <a href="mailto:valentunnamisnuk@gmail.com">Valentyn Namisnyk</a>
 *
 * @date 2016-08-06 12:30 :: 2016-08-06 12:32
 *
 * @address /Ukraine/Ivano-Frankivsk/Rozhniw
 *                                                                  *
 *///*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *

package com.familytime.model.repository;

import com.familytime.model.entity.Complexity;

import com.familytime.model.entity.Family;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplexityRepository extends JpaRepository<Complexity, Long> {
    
    List<Complexity> findByFamily(Family family);
}
