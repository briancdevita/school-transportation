package com.transporte.notification.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.transporte.notification.model.BusLocationUpdateEvent;

@Service
public class BusLocationConsumer {

    @KafkaListener(
        topics = "bus-location-updates",
        groupId = "notification-group",
        containerFactory = "busLocationKafkaListenerContainerFactory"
    )
    public void consume(BusLocationUpdateEvent busLocationUpdateEvent) {
        // Here you can add logic to handle the event, like sending a notification
        // For example, sending an email or logging the event
        System.out.println("🚌 Actualización de ubicación del autobús: " + busLocationUpdateEvent.getBusId() + 
                           " - Nueva ubicación: " + busLocationUpdateEvent.getLatitude() + ", " + busLocationUpdateEvent.getLongitude() +
                           " - Hora: " + busLocationUpdateEvent.getTimestamp());
    }
}
