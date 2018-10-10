package com.devopsbuddy.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * @author Fetah
 * Real implementation of smtpService mail service
 * **/
public class SmtpMailService extends AbstractEmailService {

    /** The application Logger **/
    private static final Logger LOG = LoggerFactory.getLogger(SmtpMailService.class);

    @Autowired
    private MailSender mailSender;

    @Override
    public void sendGenericEmailMessage(SimpleMailMessage message) {
    LOG.debug("Sending email for: {}",message);
    mailSender.send(message);
    LOG.info("Email sent.");
    }
}
