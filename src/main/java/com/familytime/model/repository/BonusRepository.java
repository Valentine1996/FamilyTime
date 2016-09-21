/**
 * Created by Andrii Gaidychuk on 15.09.2016.
 */

package com.familytime.model.repository;

import com.familytime.model.entity.Bonus;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface for work with persistence layout
 * @version 1.0
 */
public interface BonusRepository extends JpaRepository<Bonus, Long> {
}
