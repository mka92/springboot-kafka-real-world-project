package pl.mka92.springboot;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import pl.mka92.springboot.dao.model.WikimediaData;
import pl.mka92.springboot.dao.repository.WikimediaDataRepository;

@Slf4j
@RequiredArgsConstructor
@Service
public class KafkaDatabaseConsumer {

    public static final String WIKIMEDIA_RECENT_CHANGE_TOPIC = "wikimedia_recent_change";

    private final WikimediaDataRepository wikimediaDataRepository;
    @KafkaListener(topics = WIKIMEDIA_RECENT_CHANGE_TOPIC)
    public void consume(String eventMessage) {
        log.info("Message received -> {}", eventMessage);
        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikimediaEventData(eventMessage);
        wikimediaDataRepository.save(wikimediaData);
    }
}
