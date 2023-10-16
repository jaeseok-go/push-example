package jaeseok.push.server.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "${message.topic.name}", groupId = ConsumerConfig.GROUP_ID_CONFIG)
    public void consume(String message) {
        log.info(">>>>>>>>>> SERVER >>>>>>>>>>");
        log.info("KafkaConsumer.consume() message : {}", message);
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }
}
