package com.example.onlineretailer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class ProductSuggestionTopicListener {

    @KafkaListener(topics = "product_suggestions_topic", groupId = "group1")
    public void consume(
            @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
            @Header(KafkaHeaders.RECEIVED_TIMESTAMP) String timestamp,
            ConsumerRecord<String, Object> value
    ) {
        System.out.println(
                String.format("********** MyObjectConsumer.consumer() consumed message: key %s, topic %s, timestamp %s, value %s",
                        key,
                        topic,
                        timestamp,
                        value.value()
                ));
    }
}
