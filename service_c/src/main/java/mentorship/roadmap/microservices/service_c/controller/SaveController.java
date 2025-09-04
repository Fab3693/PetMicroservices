package mentorship.roadmap.microservices.service_c.controller;

import mentorship.roadmap.microservices.service_c.dto.MessageDto;
import mentorship.roadmap.microservices.service_c.service.KafkaProducerService;
import mentorship.roadmap.microservices.service_c.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SaveController {

    private final MessageService messageService;
    private final KafkaProducerService kafkaProducer;

    public SaveController(MessageService messageService, KafkaProducerService kafkaProducer) {
        this.messageService = messageService;
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody MessageDto messageDto) {
        messageService.save(messageDto);
        kafkaProducer.send(messageDto);
        return ResponseEntity.ok().build();
    }
}
