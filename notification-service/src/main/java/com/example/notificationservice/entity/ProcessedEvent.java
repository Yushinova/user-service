package com.example.notificationservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "processed_events")
public class ProcessedEvent {
    @Id
    @Column(name = "event_id")
    private UUID eventId;

    @Column(name = "processed_at", nullable = false)
    private Instant create_at;

    public ProcessedEvent() {}

    public ProcessedEvent(UUID eventId, Instant create_at) {
        this.eventId = eventId;
        this.create_at = create_at;
    }

    public UUID getEventId() {
        return eventId;
    }

    public Instant getCreate_at() {
        return create_at;
    }
}
