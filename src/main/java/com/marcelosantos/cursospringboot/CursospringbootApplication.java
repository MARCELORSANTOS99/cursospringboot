package com.marcelosantos.cursospringboot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.marcelosantos.cursospringboot.services.S3Service;

@EnableWebMvc
@SpringBootApplication
public class CursospringbootApplication implements CommandLineRunner {
	

	@Autowired
	private S3Service s3Service;

	public static void main(String[] args) {
		SpringApplication.run(CursospringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//s3Service.uploadFile("E:\\Pictures\\amor\\20200216_130143.jpg");
		
		
	}

}
