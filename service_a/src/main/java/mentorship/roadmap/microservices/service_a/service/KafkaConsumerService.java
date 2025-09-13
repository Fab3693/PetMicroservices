package mentorship.roadmap.microservices.service_a.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import mentorship.roadmap.microservices.service_a.dto.MessageDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Data
public class KafkaConsumerService {
    private final MongoService mongoService;
    private final RestService restService;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "in", groupId = "service-a")
    public void listen(String message) {
        log.info("Получено сообщение (raw): {}", message);
        try {
            MessageDto dto = objectMapper.readValue(message, MessageDto.class);
            mongoService.save(dto);
            restService.sendToServiceB(dto);
        } catch (Exception e) {
            log.error("Ошибка десериализации", e);
        }
    }
}
