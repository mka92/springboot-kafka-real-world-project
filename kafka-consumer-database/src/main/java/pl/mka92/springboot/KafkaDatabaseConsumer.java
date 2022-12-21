package pl.mka92.springboot;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class KafkaDatabaseConsumer {

    public static final String WIKIMEDIA_RECENT_CHANGE_TOPIC = "wikimedia_recent_change";

    @KafkaListener(topics = WIKIMEDIA_RECENT_CHANGE_TOPIC)
    public void consume(String eventMessage) {
        log.info("Message received -> {}", eventMessage);
    }
}
