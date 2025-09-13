package mentorship.roadmap.microservices.service_c.service;

import lombok.AllArgsConstructor;
import mentorship.roadmap.microservices.service_c.dto.MessageDto;
import mentorship.roadmap.microservices.service_c.entity.MessageEntity;
import mentorship.roadmap.microservices.service_c.mapper.MessageMapper;
import mentorship.roadmap.microservices.service_c.repository.MessageRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageService {

    private final MessageRepository repository;
    private final MessageMapper mapper;

    public void save(MessageDto dto) {
        MessageEntity entity = mapper.toEntity(dto);
        repository.save(entity);
    }
}
