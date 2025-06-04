package com.tracking_service.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.tracking_service.model.BusLocationUpdateEvent;

@Service
public class TrakcingService {


    private final KafkaTemplate<String, BusLocationUpdateEvent> kafkaTemplate;


    public TrakcingService(KafkaTemplate<String, BusLocationUpdateEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void sendLocation(BusLocationUpdateEvent event) {
        kafkaTemplate.send("bus-location-updates", event);
        System.out.println("Location update sent: " + event.getLatitude() + ", " + event.getLongitude());
    }
    
}
