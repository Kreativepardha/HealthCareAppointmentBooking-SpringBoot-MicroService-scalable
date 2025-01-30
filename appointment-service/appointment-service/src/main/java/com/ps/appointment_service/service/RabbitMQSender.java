package com.ps.appointment_service.service;


import com.ps.appointment_service.dto.AppointmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMQSender {

    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routingKey}")
    private String routingKey;

    public void sendAppointmentNotification(AppointmentDTO appointmentDTO) {
        rabbitTemplate.convertAndSend(exchange, routingKey, appointmentDTO);
    }
}
