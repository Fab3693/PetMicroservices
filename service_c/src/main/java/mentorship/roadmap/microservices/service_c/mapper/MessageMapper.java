package mentorship.roadmap.microservices.service_c.mapper;

import mentorship.roadmap.microservices.service_c.dto.MessageDto;
import mentorship.roadmap.microservices.service_c.entity.MessageEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
public interface MessageMapper {
    MessageEntity toEntity(MessageDto dto);
}
