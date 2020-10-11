package com.pe.delivery.config;

//import com.wesley.cursomc.services.DBService;
import com.pe.delivery.services.EmailService;
import com.pe.delivery.services.MockEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


import java.text.ParseException;

@Configuration
@Profile("test")
public class TestConfig {

    //@Autowired
    //private DBService dbService;
    @Bean
    public  boolean instantiateDatabase() throws ParseException {
        //dbService.instatiateTestDatabase();
        return true;
    }

    @Bean
    public EmailService emailService() {
        return new MockEmailService();
    }
}
