package com.marcelosantos.cursospringboot.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.marcelosantos.cursospringboot.services.DBServices;
import com.marcelosantos.cursospringboot.services.EmailService;
import com.marcelosantos.cursospringboot.services.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBServices dbServices;
	
	@Bean
	public boolean instatiateDataBase() throws ParseException {
		
		dbServices.instatiateTestDataBase();
		return true;
	}
	
	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}

}
