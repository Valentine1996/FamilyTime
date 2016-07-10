/// *** *** Model :: Service :: FamilyService *** *** *** *** *** *///

/** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *
 *                                                                  *
 * @copyright 2016 (c), by Valentine
 *
 * @author Valentyn Namisnyk <valentunnamisnuk@gmail.com>
 *
 * @date 2016-07-10 12:35:15 :: 2016-07-10 12:45:05
 *
 * @address /Ukraine/Ivano-Frankivsk/Rozhniw
 *                                                                  *
 *///*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** *

/// *** Code    *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ///
package com.familytime.model.service;

import com.familytime.model.entity.Family;

import java.util.List;

public interface FamilyService {
    //- SECTION :: MAIN -//
    /**
     * Find families for page
     *
     * @return List < Family > List of families
     */
    public List<Family> findAll();

    /**
     * Create
     *
     * @param family Data for create new Family
     * @return Created family
     */
    public Family create( Family family );

    /**
     * Find family by id
     *
     * @param id Unique identificator
     * @return Family Found
     */
    public Family find( Long id );

    /**
     * Update
     *
     * @param family Family for update
     * @return Family Updated
     */
    public Family update( Family family );

    /**
     * Delete
     *
     * @param id Identificator of family
     */
    public void delete( Long id );
}
