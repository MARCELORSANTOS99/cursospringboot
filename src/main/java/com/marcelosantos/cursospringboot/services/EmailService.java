package com.marcelosantos.cursospringboot.services;

import org.springframework.mail.SimpleMailMessage;

import com.marcelosantos.cursospringboot.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	void sendEmail(SimpleMailMessage msg);
	

}
