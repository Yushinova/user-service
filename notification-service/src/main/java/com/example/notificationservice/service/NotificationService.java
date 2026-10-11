package com.example.notificationservice.service;

import com.example.notificationservice.entity.ProcessedEvent;
import com.example.notificationservice.repository.ProcessedEventRepository;
import com.example.notificationservice.kafka.UserEvent;
import com.example.notificationservice.kafka.UserOperation;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class NotificationService {
    private final ProcessedEventRepository processedEventRepository;
    private final EmailService emailService;

    public NotificationService(
            ProcessedEventRepository processedEventRepository,
            EmailService emailService) {

        this.processedEventRepository = processedEventRepository;
        this.emailService = emailService;
    }

    public void process(UserEvent event) {

        if (processedEventRepository.existsById(event.eventId())) {
            return;
        }

        emailService.sendEmail(
                event.email(),
                getMessage(event.operation())
        );

        ProcessedEvent processedEvent = new ProcessedEvent(
                event.eventId(),
                Instant.now()
        );

        processedEventRepository.save(processedEvent);
    }

    private String getMessage(UserOperation operation) {

        if (operation == UserOperation.CREATE) {
            return "Здравствуйте! Ваш аккаунт на сайте был успешно создан.";
        }

        return "Здравствуйте! Ваш аккаунт был удалён.";
    }
}
