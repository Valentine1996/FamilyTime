package com.familytime.security.model.service;

import com.familytime.model.entity.Family;
import com.familytime.notification.model.entity.Contact;
import com.familytime.security.model.entity.RecoveryAccess;

import java.io.IOException;
import java.util.List;

/**
 * Service for recovery access to account.
 *
 * @version 1.0
 */
public interface AccessRecoveryService {
    /**
     * Make request because of loosing access to account.
     *
     * @param contact    Contact associated to account.
     *
     * @throws IOException  Cannot send via SMTP.
     */
    void lostAccess( Contact contact ) throws IOException;

    /**
     * Restore access.
     *
     * @param hash        One time hash.
     * @param password    New password.
     */
    void restore( String hash, String password );

    /**
     * Create a new recovery access.
     *
     * @param recoveryAccess Data for creating new family
     * @return RecoveryAccess Created
     */
    public RecoveryAccess create(RecoveryAccess recoveryAccess);

    /**
     * Find the recovery access by hash.
     *
     * @param hash Access hash
     * @return RecoveryAccess Found
     */
    public RecoveryAccess findByHash(String hash);

    /**
     * Delete by hash.
     *
     * @param hash Hash got from the link.
     */
    public void delete( String  hash );

    /**
     * Get valid access.
     *
     * @param hash Hash got from the link.
     */
    public RecoveryAccess getValidAccess(String hash);
}
