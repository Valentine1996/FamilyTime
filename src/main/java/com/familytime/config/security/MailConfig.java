package com.familytime.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailSender;

import java.util.Properties;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Profile("default")
@Configuration
@EnableConfigurationProperties
@PropertySource("classpath:config/mail/config.properties")
public class MailConfig {

    @Autowired
    private Environment env;

    @Value("${email.host}")
    private String host;

    @Value("${email.port}")
    private Integer port;

    @Value("${email.username}")
    private String username;

    @Value("${email.password}")
    private String password;

    /**
     * Mail Sender .
     *
     * @return MailSender
     */
    @Bean
    public MailSender javaMailService() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

        javaMailSender.setHost(host);
        javaMailSender.setPort(port);
        javaMailSender.setUsername(username);
        javaMailSender.setPassword(password);

        javaMailSender.setJavaMailProperties(getMailProperties());

        return javaMailSender;
    }

    /**
     * Get mail properties.
     *
     * @return Properties
     */
    private Properties getMailProperties() {
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol",
                                env.getProperty("mail.transport.protocol"));
        properties.setProperty("mail.smtp.auth",
                                env.getProperty("mail.smtp.auth"));
        properties.setProperty("mail.smtp.starttls.enable",
                                env.getProperty("mail.smtp.starttls.enable"));
        properties.setProperty("mail.debug", env.getProperty("mail.debug"));
        return properties;
    }
}
