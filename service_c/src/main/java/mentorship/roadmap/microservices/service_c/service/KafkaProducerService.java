package mentorship.roadmap.microservices.service_c.service;

import mentorship.roadmap.microservices.service_c.dto.MessageDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final String TOPIC = "out";
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(MessageDto message) {
        String payload = String.format("{\"id\":%d,\"type\":\"%s\",\"content\":\"%s\",\"createdAt\":\"%s\"}",
                message.getId(), message.getType(), message.getContent(), message.getCreatedAt().toString());
        kafkaTemplate.send(TOPIC, "message-" + message.getId(), payload);
    }
}
