package jaeseok.push.client;

import jaeseok.push.client.config.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/test")
@RestController
public class TestController {

    private final KafkaProducer kafkaProducer;

    @PostMapping("/kafka/produce")
    public void sendMessage(@RequestParam("message") String message) {
        kafkaProducer.sendMessage(message);
    }
}
