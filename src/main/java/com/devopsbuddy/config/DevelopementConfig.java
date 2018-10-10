package com.devopsbuddy.config;

import com.devopsbuddy.backend.service.EmailService;
import com.devopsbuddy.backend.service.FatehEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Fetah
 * */
@Configuration
@Profile("dev")
@PropertySource("file:///${user.home}/dev/application-dev.properties")
public class DevelopementConfig {

    @Bean
    public EmailService emailService(){
        return new FatehEmailService();
    }
}
