package mentorship.roadmap.microservices.service_c.service;


import mentorship.roadmap.microservices.service_c.dto.MessageDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final String topic;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate, @Value("${app.kafka.topic}") String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    public void send(MessageDto message) {
        String payload = String.format("{\"id\":%d,\"type\":\"%s\",\"content\":\"%s\",\"createdAt\":\"%s\"}",
                message.getId(), message.getType(), message.getContent(), message.getCreatedAt().toString());
        kafkaTemplate.send(topic, "message-" + message.getId(), payload);
    }
}
