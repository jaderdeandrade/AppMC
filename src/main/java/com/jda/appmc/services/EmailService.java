package com.jda.appmc.services;

import org.springframework.mail.SimpleMailMessage;

import com.jda.appmc.domain.Cliente;
import com.jda.appmc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Cliente cliente, String newPass);
}