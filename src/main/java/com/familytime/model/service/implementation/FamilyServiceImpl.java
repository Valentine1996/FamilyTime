/// ***  Model :: Service :: Implementation :: FamilyServiceImpl *///
/** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *
 *                                                                  *
 * @copyright 2016 (c), by Valentine
 *
 * @author Valentyn Namisnyk <valentunnamisnuk@gmail.com>
 *
 * @date 2016-07-10 12:50:40 :: 2016-07-10 09:20:21
 *
 * @address /Ukraine/Ivano-Frankivsk/Rozhniw */

package com.familytime.model.service.implementation;

import com.familytime.model.entity.Family;
import com.familytime.model.repository.FamilyRepository;
import com.familytime.model.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of family service
 *
 * @version 1.0
 */
@Service
public class FamilyServiceImpl implements FamilyService {
    
    @Autowired
    FamilyRepository familyRepository;
    /**
     * Find families for page
     *
     * @return List < Family > List of families
     */
    @Override
    public List<Family> findAll() {
        return this.familyRepository.findAll();
    }

    /**
     * Create
     *
     * @param family Data for creating new Family
     * @return Created family
     */
    @Override
    public Family create(Family family) {
        return this.familyRepository.save(family);
    }

    /**
     * Find family by id
     *
     * @param id Unique identificator
     * @return Family Found
     */
    @Override
    public Family find(Long id) {
        return this.familyRepository.findOne(id);
    }

    /**
     * Update
     *
     * @param family Family for update
     * @return Family Updated
     */
    @Override
    public Family update(Family family) {
        return this.familyRepository.save(family);
    }

    /**
     * Delete
     *
     * @param id Identificator of family
     */
    @Override
    public void delete(Long id) {
        this.familyRepository.delete(id);
    }
}
