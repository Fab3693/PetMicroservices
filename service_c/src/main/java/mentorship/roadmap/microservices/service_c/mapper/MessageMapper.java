package mentorship.roadmap.microservices.service_c.mapper;

import mentorship.roadmap.microservices.service_c.dto.MessageDto;
import mentorship.roadmap.microservices.service_c.entity.MessageEntity;
import org.springframework.stereotype.Component;

@Component

public class MessageMapper {

    public MessageEntity toEntity(MessageDto dto) {
        return new MessageEntity(
                dto.getId(),
                dto.getType(),
                dto.getContent(),
                dto.getCreatedAt()
        );
    }
}
