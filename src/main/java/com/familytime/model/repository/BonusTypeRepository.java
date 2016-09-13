/**
 * Created by Andrii Gaidychuk on 25.07.2016.
 */

package com.familytime.model.repository;


import com.familytime.model.entity.BonusType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Interface for work with persistence layout
 * @version 1.0
 */
@Transactional
public interface BonusTypeRepository extends JpaRepository<BonusType, Long> {
}
