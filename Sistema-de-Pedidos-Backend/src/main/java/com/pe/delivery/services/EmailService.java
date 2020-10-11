package com.pe.delivery.services;

import com.pe.delivery.domain.Pedido;
import org.springframework.mail.SimpleMailMessage;
public interface EmailService {

    void sendOrderConfirmationEmail(Pedido obj);

    void sendEmail(SimpleMailMessage msg);
}