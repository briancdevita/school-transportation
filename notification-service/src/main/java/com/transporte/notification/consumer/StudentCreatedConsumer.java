package com.transporte.notification.consumer;
import org.springframework.kafka.annotation.KafkaListener;

import org.springframework.stereotype.Service;

import com.transporte.notification.model.StudentCreateEvent;

@Service
public class StudentCreatedConsumer {
    
    @KafkaListener(topics = "student-created",groupId = "notification-group",containerFactory = "studentCreatedKafkaListenerContainerFactory" )
    public void consume(StudentCreateEvent studentCreateEvent) { 
        // Here you can add logic to handle the event, like sending a notification
        // For example, sending an email or logging the event
        System.out.println("📩 Nuevo estudiante registrado: " + studentCreateEvent.getFirstName() + " (ID: " + studentCreateEvent.getId() + ")");

    }

}
