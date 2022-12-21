package pl.mka92.springboot;


import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import com.launchdarkly.eventsource.background.BackgroundEventSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
@Service
public class WikimediaChangesProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;


    public void sendMessage() throws InterruptedException {
        // tor read real time stream data from wikimedia, we use event source
        BackgroundEventHandler backgroundEventHandler = new WikimediaChangesHandler(kafkaTemplate);
        BackgroundEventSource.Builder eventSourceBuilder = new BackgroundEventSource.Builder(backgroundEventHandler, new EventSource.Builder(WikimediaChangesHandler.WIKIMEDIA_STREAM_URI));
        try (BackgroundEventSource backgroundEventSource = eventSourceBuilder.build()) {
            backgroundEventSource.start();
            TimeUnit.MINUTES.sleep(10);
        }


    }

}
