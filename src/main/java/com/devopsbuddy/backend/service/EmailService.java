package com.devopsbuddy.backend.service;

import com.devopsbuddy.web.domain.frontend.FeedbackPojo;
import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.mail.SimpleMailMessage;

/**
 * @author Fetah
 * 10/10/2018
 * */

public interface EmailService {
    /**
     * @param feedbackPojo The feedback Pojo
     * */
    public void sendFeedbackEmail(FeedbackPojo feedbackPojo);

    /**
     * @param message the object containing the email content
     * */
    public void sendGenericEmailMessage(SimpleMailMessage message);


}
