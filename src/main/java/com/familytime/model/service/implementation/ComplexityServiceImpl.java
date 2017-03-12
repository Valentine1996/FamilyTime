/** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *
 *                                                                  *
 * @copyright 2016 (c), by Valentine
 *
 * @author <a href="mailto:valentunnamisnuk@gmail.com">Valentyn Namisnyk</a>
 *
 * @date 2016-06-08 12:39 :: 2016-06-08 12:44
 *
 * @address /Ukraine/Ivano-Frankivsk/Rozhniw
 *                                                                  *
 *///*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *

package com.familytime.model.service.implementation;

import com.familytime.model.entity.Complexity;
import com.familytime.model.entity.Family;
import com.familytime.model.repository.ComplexityRepository;
import com.familytime.model.service.ComplexityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of Complexity service.
 *
 * @version 1.0
 */
@Service
public class ComplexityServiceImpl implements ComplexityService {

    @Autowired
    ComplexityRepository complexityRepository;
    /**
     * Find complexity by ID.
     *
     * @param id Identification of the complexity
     * @return Complexity found
     */
    @Override
    public Complexity findById(Long id) {
        return this.complexityRepository.findOne(id);
    }

    /**
     * Find all existed complexities.
     *
     * @return List < Complexity > List of complexities
     */
    @Override
    public List<Complexity> findAll() {
        return this.complexityRepository.findAll();
    }

    /**
     * Find all existed complexities by user's family.
     *
     * @param family - User's family.
     *
     * @return List < Complexity > List of complexities.
     */
    @Override
    public List<Complexity> findByFamily(Family family) {
        return this.complexityRepository.findByFamily(family);
    }

    /**
     * Create new complexity.
     *
     * @param complexity Data for creating new complexity
     * @return Complexity created
     */
    @Override
    public Complexity create(Complexity complexity) {
        return this.complexityRepository.save(complexity);
    }

    /**
     * Updated existed complexity.
     *
     * @param complexity Data for updating complexity
     * @return Complexity updated
     */
    @Override
    public Complexity update(Complexity complexity) {
        return this.complexityRepository.save(complexity);
    }

    /**
     * Delete existed complexity.
     *
     * @param id Identification of the complexity
     */
    @Override
    public void delete(Long id) {
        this.complexityRepository.delete(id);
    }
}
