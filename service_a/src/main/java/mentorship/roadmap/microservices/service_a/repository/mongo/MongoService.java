package mentorship.roadmap.microservices.service_a.repository.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import mentorship.roadmap.microservices.service_a.dto.MessageDto;
import mentorship.roadmap.microservices.service_a.repository.MessageRepository;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class MongoService {
    private final MessageRepository repository;

    public void save(MessageDto messageDto){
        repository.save(new MessageDocument
                (messageDto.getId(),
                messageDto.getType(),
                messageDto.getContent()));
    }
}
