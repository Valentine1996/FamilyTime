package com.familytime.security.model.service;

import com.familytime.notification.model.entity.Contact;

import java.io.IOException;

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
}
