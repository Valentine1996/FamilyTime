package com.familytime.model.repository;

import com.familytime.security.model.entity.RecoveryAccess;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface for work with persistence layout
 * @version 1.0
 */
public interface AccessRecoveryRepository extends JpaRepository<RecoveryAccess, Long> {
    /**
     * Find by hash.
     *
     * @param hash    One time hash.
     *
     * @return RecoveryAccess.
     */
    RecoveryAccess findByHash(String hash );
}
