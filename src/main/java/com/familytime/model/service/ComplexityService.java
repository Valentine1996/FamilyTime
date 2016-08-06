/** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *
 *                                                                  *
 * @copyright 2016 (c), by Valentine
 *
 * @author <a href="mailto:valentunnamisnuk@gmail.com">Valentyn Namisnyk</a>
 *
 * @date 2016-06-08 12:32 :: 2016-06-08 12:37
 *
 * @address /Ukraine/Ivano-Frankivsk/Rozhniw
 *                                                                  *
 *///*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *

package com.familytime.model.service;

import com.familytime.model.entity.Complexity;

import java.util.List;

public interface ComplexityService {
    //- SECTION :: MAIN -//

    /**
     * Find complexity by ID.
     * 
     * @return Complexity found
     */
    public Complexity findById(Long id);

    /**
     * Find all existed complexities.
     *
     * @return List < Complexity > List of complexities
     */
    public List<Complexity> findAll();

    /**
     * Create new complexity.
     *
     * @param complexity Data for creating new complexity
     * @return Complexity created
     */
    public Complexity create(Complexity complexity);

    /**
     * Updated existed complexity.
     *
     * @param complexity Data for updating complexity
     * @return Complexity updated
     */
    public Complexity update(Complexity complexity);

    /**
     * Delete existed complexity.
     *
     * @param id Identification of the complexity
     */
    public void delete(Long id);
}
