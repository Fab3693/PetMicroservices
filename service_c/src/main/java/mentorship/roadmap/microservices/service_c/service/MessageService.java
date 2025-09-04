package mentorship.roadmap.microservices.service_c.service;

import mentorship.roadmap.microservices.service_c.dto.MessageDto;
import mentorship.roadmap.microservices.service_c.entity.MessageEntity;
import mentorship.roadmap.microservices.service_c.repository.MessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final MessageRepository repository;

    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public void save(MessageDto dto) {
        MessageEntity entity = new MessageEntity(
                dto.getId(),
                dto.getType(),
                dto.getContent(),
                dto.getCreatedAt()
        );
        repository.save(entity);
    }
}
