package com.example.notificationservice.controller;

import com.example.notificationservice.kafka.UserEvent;
import com.example.notificationservice.kafka.UserOperation;
import com.example.notificationservice.service.EmailService;
import com.example.notificationservice.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<Void> sendNotification(
            @RequestBody UserEvent event) {

        notificationService.process(event);

        return ResponseEntity.ok().build();
    }

}