package com.example.notificationservice.kafka;

import com.example.notificationservice.service.EmailService;
import com.example.notificationservice.service.NotificationService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UserEventConsumer {
    private final NotificationService notificationService;

    public UserEventConsumer(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @KafkaListener(topics = "user-events")
    public void consume(UserEvent event) {

        notificationService.process(event);

    }
}
