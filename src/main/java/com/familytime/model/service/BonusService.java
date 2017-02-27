/**
 * Created by Andrii Gaidychuk on 15.09.2016.
 */

package com.familytime.model.service;

import com.familytime.model.entity.Bonus;

import java.util.List;

public interface BonusService {

    //- SECTION :: MAIN -//

    /**
     * Find bonus by ID
     * @return Bonus found.
     */
    public Bonus findById(Long id);

    /**
     * Find all existed bonus
     * @return List < Bonus > List of bonuses.
     */
    public List<Bonus> findAll();

    /**
     * Create new bonus.
     * @param bonus Data for creating new bonus
     * @return Bonus created
     */
    public Bonus create(Bonus bonus);

    /**
     * Updated existed bonus.
     * @param bonus Data for updated bonus
     * @return Bonus updated
     */
    public Bonus update(Bonus bonus);

    /**
     * Delete existed bonus.
     * @param id identificator for delete bonus
     */
    public void delete(Long id);
}
