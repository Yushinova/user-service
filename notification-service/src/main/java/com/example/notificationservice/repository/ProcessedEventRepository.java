package com.example.notificationservice.repository;

import com.example.notificationservice.entity.ProcessedEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProcessedEventRepository
        extends JpaRepository<ProcessedEvent, UUID> {
}