package com.ps.appointment_service.service;


import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "appointment-events";

    public void sendAppointmentEvents(String message) {
        kafkaTemplate.send(TOPIC, message);
    }
}
