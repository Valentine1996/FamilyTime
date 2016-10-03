/**
 * Created by Andrii Gaidychuk on 24.09.2016.
 */

package com.familytime.model.repository;

import com.familytime.model.entity.Task;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface for work with persistence layout
 * @version 1.0
 */
public interface TaskRepository extends JpaRepository<Task, Long> {
}
