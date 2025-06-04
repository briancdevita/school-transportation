package com.tracking_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracking_service.TrackingServiceApplication;
import com.tracking_service.model.BusLocationUpdateEvent;
import com.tracking_service.service.TrakcingService;

@RestController
@RequestMapping("/api/location")
public class TrackingController {


    private final TrakcingService trackingService;
    public TrackingController(TrakcingService trackingService) {
        this.trackingService = trackingService;
    }

    @PostMapping
    public ResponseEntity<String> updateLocation (@RequestBody BusLocationUpdateEvent event) {
        trackingService.sendLocation(event);
        return ResponseEntity.ok("Location update sent successfully");
    }

    
}
