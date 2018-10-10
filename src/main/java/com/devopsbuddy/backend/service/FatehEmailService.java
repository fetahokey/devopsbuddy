package com.devopsbuddy.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

public class FatehEmailService extends AbstractEmailService {
    
    /** The application Logger **/
    private static final Logger LOG = LoggerFactory.getLogger(FatehEmailService.class);
    
    @Override
    public void sendGenericEmailMessage(SimpleMailMessage message) {
        LOG.debug("Simulating an email service ...");
        LOG.info(message.toString());
        LOG.debug("Email sent.");
    }
}
