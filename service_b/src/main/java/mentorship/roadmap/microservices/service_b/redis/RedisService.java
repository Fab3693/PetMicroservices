package mentorship.roadmap.microservices.service_b.redis;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import mentorship.roadmap.microservices.service_b.dto.MessageDto;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Slf4j
@Service
@Data
public class RedisService {

    private final RedisTemplate<String, Object> redisTemplate;

    public void save(MessageDto messageDto){
        String key = "message:"+messageDto.getId();
        redisTemplate.opsForValue().set(key, messageDto, Duration.ofMinutes(5));
        log.info("Сохранено в Redis: {}", key);
    }
}
