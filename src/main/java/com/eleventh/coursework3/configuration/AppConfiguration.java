package com.eleventh.coursework3.configuration;

import com.eleventh.coursework3.service.UtilService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class AppConfiguration {
    @Bean
    public Random random() {
        return new Random();
    }

    @Bean
    public UtilService utilService(){
        return new UtilService();
    }
}
