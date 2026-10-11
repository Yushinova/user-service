package com.example.userservice.kafka;

import java.util.UUID;

public record UserEvent(
        UUID eventId,
        UserOperation operation,
        String email
) { }
