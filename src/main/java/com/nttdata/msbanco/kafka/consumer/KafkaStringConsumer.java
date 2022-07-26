package com.nttdata.msbanco.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaStringConsumer {
    /*Logger logger = LoggerFactory.getLogger(KafkaStringConsumer.class);

    @KafkaListener(topics = "TOPIC-DEMO", groupId = "group_id")
    public void getMessage(String message) {
        logger.info("Consuming Message {}", message);
    }*/
}
