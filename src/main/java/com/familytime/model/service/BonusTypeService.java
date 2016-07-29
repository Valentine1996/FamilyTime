/**
 * Created by Andrii Gaidychuk on 25.07.2016.
 */

package com.familytime.model.service;

import com.familytime.model.entity.BonusType;

import java.util.List;

public interface BonusTypeService {

    //- SECTION :: MAIN -//

    /**
     * Find bonus type by ID
     * @return BonusType found.
     */
    public BonusType findById(Long id);

    /**
     * Find all existed bonus type
     * @return List < BonusType > List of bonus types.
     */
    public List<BonusType> findAll();

    /**
     * Create new bonus type
     * @param bonusType Data for creating new bonus type
     * @return BonusType created
     */
    public BonusType create(BonusType bonusType);

    /**
     * Updated existed bonus type
     * @param bonusType Data for updated bonus type
     * @return BonusType updated
     */
    public BonusType update(BonusType bonusType);

    /**
     * Delete existed bonus type
     * @param id identificator for delete bonus type
     */
    public void delete(Long id);
}
