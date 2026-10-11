package com.example.notificationservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
 private final JavaMailSender sender;
    @Value("${spring.mail.username}")
    private String from;
    public EmailService(JavaMailSender sender) {
        this.sender = sender;
    }

    public void sendEmail(String email, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(email);
        mailMessage.setSubject("Уведомление");
        mailMessage.setText(message);

       sender.send(mailMessage);
    }
}
