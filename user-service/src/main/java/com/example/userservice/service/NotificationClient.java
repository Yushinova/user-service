package com.example.userservice.service;

import com.example.userservice.kafka.UserEvent;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class NotificationClient {
    private final RestClient restClient;

    public NotificationClient(RestClient.Builder builder) {
        this.restClient = builder.baseUrl("http://localhost:8081").build();
    }

    public void sendNotification(UserEvent event){
        restClient.post()
                .uri("/notifications")
                .body(event)
                .retrieve()
                .toBodilessEntity();
    }
}
