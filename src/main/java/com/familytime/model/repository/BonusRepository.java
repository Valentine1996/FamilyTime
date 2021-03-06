/**
 * Created by Andrii Gaidychuk on 15.09.2016.
 */

package com.familytime.model.repository;

import com.familytime.model.entity.Bonus;
import com.familytime.model.entity.BonusType;
import com.familytime.model.entity.Family;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Interface for work with persistence layout
 * @version 1.0
 */
public interface BonusRepository extends JpaRepository<Bonus, Long> {
    @Query("select b " +
            "from Bonus b FETCH ALL PROPERTIES " +
            "where b.bonusType.family = :family")
    List<Bonus> findByFamily(@Param("family") Family family);

    List<Bonus> findByBonusType(BonusType bonusType);
}
