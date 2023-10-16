package jaeseok.push.client.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class KafkaProducer {
    @Value("${message.topic.name}")
    private String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        log.info(">>>>>>>>>> CLIENT >>>>>>>>>>");
        log.info("KafkaProducer.sendMessage() message ===> {}", message);
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        this.kafkaTemplate.send(topicName, message);
    }
}
