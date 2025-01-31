package com.ps.notification_service.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "appointment-events", groupId = "notification-group")
    public void consumeAppointmentEvent(String message) {
        log.info("Received Appointment Notification: {}", message);

    }
}
