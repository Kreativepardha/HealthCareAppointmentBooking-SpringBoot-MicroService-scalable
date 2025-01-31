package com.ps.notification_service.service;


import com.ps.notification_service.dto.AppointmentNotification;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMQListener {

    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void consumeMessage(AppointmentNotification appointmentNotification) {
        System.out.println("📩 Received Appointment Notification: " + appointmentNotification);
        notificationService.sendNotification(appointmentNotification);
    }
}
