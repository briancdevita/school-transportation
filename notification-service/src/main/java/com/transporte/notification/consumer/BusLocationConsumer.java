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
      
        System.out.println("🚌 Actualización de ubicación del autobús: " + busLocationUpdateEvent.getBusId() + 
                           " - Nueva ubicación: " + busLocationUpdateEvent.getLatitude() + ", " + busLocationUpdateEvent.getLongitude() +
                           " - Hora: " + busLocationUpdateEvent.getTimestamp());
    }
}
