package com.tracking_service.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.tracking_service.model.BusLocation;
import com.tracking_service.model.BusLocationUpdateEvent;

import com.tracking_service.service.TrakcingService;

@RestController
@RequestMapping("/api/location")
public class TrackingController {


    



    private static final double SCHOOL_LATITUDE = -38.0055; 
    private static final double SCHOOL_LONGITUDE = -57.5426;

  
    private final KafkaTemplate<String, BusLocation> kafkaTemplate;
    private final TrakcingService trackingService;

    public TrackingController(KafkaTemplate<String, BusLocation> kafkaTemplate, TrakcingService trackingService) {
        this.kafkaTemplate = kafkaTemplate;
        this.trackingService = trackingService;
    }



    @PostMapping("/track")
    public ResponseEntity<String> trackBus(@RequestBody BusLocation location) {
        double distance = calculateDistance(location.getLatitude(), location.getLongitude(), SCHOOL_LATITUDE, SCHOOL_LONGITUDE);
        
        System.out.println("📍 Location received. Distance to school: " + distance + " km");

        if (distance <= 1.0) {
            kafkaTemplate.send("bus-near-events", location);
            System.out.println("🚨 Bus is near the school! Event sent.");
        }

        return ResponseEntity.ok("Location received. Distance to school: " + distance + " km");
    }

    // Fórmula Haversine para calcular la distancia entre dos puntos geográficos
    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        int R = 6371; // radio de la Tierra en km
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                   Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                   Math.sin(dLon/2) * Math.sin(dLon/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return R * c;
    }

    



    @PostMapping
    public ResponseEntity<String> updateLocation (@RequestBody BusLocationUpdateEvent event) {
        trackingService.sendLocation(event);
        return ResponseEntity.ok("Location update sent successfully");
    }

    
}
