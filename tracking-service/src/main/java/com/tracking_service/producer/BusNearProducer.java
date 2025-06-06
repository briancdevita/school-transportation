package com.tracking_service.producer;



import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.tracking_service.model.BusNearEvent;

@Component
public class BusNearProducer {

    private final KafkaTemplate<String, BusNearEvent> kafkaTemplate;

    public BusNearProducer(KafkaTemplate<String, BusNearEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendBusNearEvent(com.tracking_service.model.BusNearEvent event) {
        System.out.println("🚍 Enviando evento: Bus cerca del colegio -> " + event.getBusId());
        kafkaTemplate.send("bus-near-events", event);
        System.out.println("🚍 Evento enviado: Bus cerca del colegio -> " + event.getBusId());
    }
}
