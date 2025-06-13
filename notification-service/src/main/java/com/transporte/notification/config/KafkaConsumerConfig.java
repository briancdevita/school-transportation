package com.transporte.notification.config;

import com.transporte.notification.model.BusLocationUpdateEvent;
import com.transporte.notification.model.BusNearEvent;
import com.transporte.notification.model.StudentCreateEvent;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public ConsumerFactory<String, StudentCreateEvent> consumerFactory() {
        JsonDeserializer<StudentCreateEvent> deserializer = new JsonDeserializer<>(StudentCreateEvent.class);
        deserializer.setRemoveTypeHeaders(false);
        deserializer.addTrustedPackages("*");
        deserializer.setUseTypeMapperForKey(true);
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "notification-group");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

          return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), deserializer);
    }

    @Bean(name = "studentCreatedKafkaListenerContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<String, StudentCreateEvent> factory() {
        ConcurrentKafkaListenerContainerFactory<String, StudentCreateEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }


    @Bean(name = "busLocationKafkaListenerContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<String, BusLocationUpdateEvent> busLocationKafkaListenerContainerFactory() {
    JsonDeserializer<BusLocationUpdateEvent> deserializer = new JsonDeserializer<>(BusLocationUpdateEvent.class);
    deserializer.setRemoveTypeHeaders(false);
    deserializer.addTrustedPackages("*");
    deserializer.setUseTypeMapperForKey(true);
    Map<String, Object> config = new HashMap<>();

    config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
    config.put(ConsumerConfig.GROUP_ID_CONFIG, "notification-group");
    config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

    ConsumerFactory<String, BusLocationUpdateEvent> factory =
        new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), deserializer);

    ConcurrentKafkaListenerContainerFactory<String, BusLocationUpdateEvent> containerFactory =
        new ConcurrentKafkaListenerContainerFactory<>();
    containerFactory.setConsumerFactory(factory);
    return containerFactory;
    }


    @Bean(name = "busNearKafkaListenerContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<String, BusNearEvent> busNearKafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, BusNearEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(busNearConsumerFactory());
    return factory;
}

    @Bean
    public ConsumerFactory<String, BusNearEvent> busNearConsumerFactory() {
        JsonDeserializer<BusNearEvent> deserializer = new JsonDeserializer<>(BusNearEvent.class);
        deserializer.setRemoveTypeHeaders(false);
        deserializer.addTrustedPackages("*");
        deserializer.setUseTypeMapperForKey(true);

        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "notification-group");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), deserializer);
    }


}
