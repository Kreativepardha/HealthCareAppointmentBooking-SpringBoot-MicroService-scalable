package com.ps.notification_service.service;


import com.ps.notification_service.dto.AppointmentNotification;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {


    public void sendNotification(AppointmentNotification appointmentNotification) {
        System.out.println("✅ Sending notification to Patient: " + appointmentNotification.getPatientId());
        System.out.println("📅 Appointment Date: " + appointmentNotification.getAppointmentDate());
        System.out.println("👨‍⚕️ Doctor ID: " + appointmentNotification.getDoctorId());
//        System.out.println("📩 Status: " + appointmentNotification.getStatus());
    }
}
