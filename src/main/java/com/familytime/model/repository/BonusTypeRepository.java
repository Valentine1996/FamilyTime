/**
 * Created by Andrii Gaidychuk on 25.07.2016.
 */

package com.familytime.model.repository;

import com.familytime.model.entity.BonusType;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface for work with persistence layout
 * @version 1.0
 */
public interface BonusTypeRepository extends JpaRepository<BonusType, Long> {
}
