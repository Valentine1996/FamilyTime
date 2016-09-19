package com.familytime.security.model.service.implementtion;

import static org.springframework.util.Assert.notNull;

import com.familytime.model.entity.User;
import com.familytime.model.repository.AccessRecoveryRepository;
import com.familytime.model.service.UserService;
import com.familytime.notification.model.entity.Contact;
import com.familytime.notification.model.entity.Email;
import com.familytime.notification.model.entity.EmailAddress;
import com.familytime.notification.model.service.NotificationService;
import com.familytime.security.model.entity.RecoveryAccess;
import com.familytime.security.model.service.AccessRecoveryService;

import com.github.jknack.handlebars.Context;
import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.context.MapValueResolver;
import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.UUID;

@Service
public class AccessRecoveryServiceImpl implements AccessRecoveryService{
    /**
     * Host name for access recovery link.
     */
    @Value("${app.hostname}")
    String hostname;
    /**
     * Template manager.
     */
    @Autowired
    private Handlebars templateManager;

    /**
     * Service for getting message.
     */
    @Autowired
    private MessageSource messageSource;

    /**
     * Encoder for create hash of password.
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Service for work with users.
     */
    @Autowired
    private UserService userService;

    /**
     * Service for sending notifications.
     */
    @Autowired
    private NotificationService notificationService;

    /**
     * Repository for work with access recovery.
     */
    @Autowired
    private AccessRecoveryRepository accessRecoveryRepository;

    /**
     * Make request because of loosing access to account.
     *
     * @param contact Contact associated to account.
     *
     * @throws IOException  Cannot send via SMTP.
     */

    @Transactional(rollbackFor = JDBCException.class)
    @Override
    public void lostAccess( Contact contact ) throws IOException {
        //- Create one-time link for recovery access -//
        //- Search user -//
        User user = this.userService.findByUsername( contact.getAddress() );

        //- Check user -//
        notNull( user );

        //- Generate one-time hash -//
        String hash = this.passwordEncoder.encode(
                UUID.randomUUID().toString()
        );

        //- Add one-time hash for recovery access -//
        this.accessRecoveryRepository.save(
                new RecoveryAccess(
                        user,
                        hash,
                        OffsetDateTime.now().plusMinutes( 15L )
                )
        );

        Object model = new Object();
        Context context = Context
                .newBuilder(model)
                .combine("hostname", hostname)
                .combine("hash", hash)
                .resolver(MapValueResolver.INSTANCE)
                .build();

        //- Prepare content -//
        Template template = this.templateManager.compile( "access-recovery" );

        //- Send notification-//
        this.notificationService.send(
            new EmailAddress( "iffamilytime@gmail.com" ),
            contact,
            new Email(
                this.messageSource.getMessage(
                        "notification.access-recovery.subject",
                        null,
                        LocaleContextHolder.getLocale()
                ),
                template.apply( context )
            )
        );
    }

    /**
     * Restore access.
     *
     * @param hash     One time hash.
     * @param password New password.
     */
    @Transactional
    @Override
    public void restore( String hash, String password ) {
        //- Search request for recovering access -//
        RecoveryAccess recoveryAccess = this.accessRecoveryRepository.findByHash( hash );

        //- Check if request was -//
        notNull( recoveryAccess );

        //- Get user -//
        User user = recoveryAccess.getUser();

        user.setPassword(passwordEncoder.encode(password));

        //- Save changes -//
        this.userService.update( user );

        //- Delete request for recovering -//
        this.accessRecoveryRepository.delete( recoveryAccess );
    }

}
