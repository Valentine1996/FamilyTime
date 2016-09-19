package com.familytime.model.service;

import com.familytime.notification.model.entity.EmailAddress;
import com.familytime.security.model.service.AccessRecoveryService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Testing email sending in prod. Do not modify.
 */
public class AccessRecoveryServiceTest extends AbstractServiceTest {
    /// *** Methods     *** ///
    /**
     * Prepare environment for test notification.
     */

    @Autowired
    AccessRecoveryService accessRecoveryService;

    @Before
    @Override
    public void tearUp() throws Exception {
        super.tearUp();

        //- Turn on SMTP Server -//
//        smtpServer.start();
    }

    @Ignore
    @Test
    public void checkPasswordRecoveryMailMessage() throws IOException {
        accessRecoveryService.lostAccess(new EmailAddress("valentunnamisnuk@gmail.com"));
        assertEquals(1,1);
    }
}
