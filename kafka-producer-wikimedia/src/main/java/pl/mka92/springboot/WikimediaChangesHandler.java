package pl.mka92.springboot;

import com.launchdarkly.eventsource.MessageEvent;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;

import java.net.URI;

@Slf4j
@RequiredArgsConstructor
public class WikimediaChangesHandler implements BackgroundEventHandler {

    public static final URI WIKIMEDIA_STREAM_URI = URI.create("https://stream.wikimedia.org/v2/stream/recentchange");

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
        log.info("event data -> {}", messageEvent.getData());
        kafkaTemplate.send(KafkaTopicConfig.WIKIMEDIA_RECENT_CHANGE_TOPIC, messageEvent.getData());
    }

    @Override
    public void onComment(String s) throws Exception {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
