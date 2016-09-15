/**
 * Created by Andrii Gaidychuk on 25.07.2016.
 */

package com.familytime.model.service.implementation;

import com.familytime.model.entity.BonusType;
import com.familytime.model.repository.BonusTypeRepository;
import com.familytime.model.service.BonusTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of bonus type service.
 *
 * @version 1.0
 */
@Service
public class BonusTypeImpl implements BonusTypeService {

    @Autowired
    BonusTypeRepository bonusTypeRepository;

    /**
     * Find bonus type by ID.
     * @param id unique identificatos
     * @return BonusType found
     */
    @Override
    public BonusType findById(Long id) {
        return this.bonusTypeRepository.findOne(id);
    }

    /**
     * Find all existed bonus type.
     * @return List < BonusType > found list bonus type
     */
    @Override
    public List<BonusType> findAll() {
        return this.bonusTypeRepository.findAll();
    }

    /**
     * Create new bonus type.
     * @param bonusType BonusType for create
     * @return BonusType created bonus type
     */
    @Override
    public BonusType create(BonusType bonusType) {
        return this.bonusTypeRepository.save(bonusType);
    }

    /**
     * Updated existed bonus type.
     * @param bonusType BonusType for update
     * @return BonusType updated bonus type
     */
    @Override
    public BonusType update(BonusType bonusType) {
        return this.bonusTypeRepository.save(bonusType);
    }

    /**
     * Delete existed bonus type.
     * @param id unique identificator bonus type
     */
    @Override
    public void delete(Long id) {
        this.bonusTypeRepository.delete(id);
    }
}
