package com.transporte.notification.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.transporte.notification.model.BusNearEvent;

@Service
public class BusNearConsumer {

    
     @KafkaListener(
         topics = "bus-near-events",
         groupId = "notification-group",
         containerFactory = "busNearKafkaListenerContainerFactory"
     )
     public void consume(BusNearEvent busNearEvent) {
        busNearEvent.setRouteId(99l);
         System.out.println("🚌 Autobús cercano: " + busNearEvent.getBusId() + 
                            " - Ruta: " + busNearEvent.getRouteId());
     }    
    
}
