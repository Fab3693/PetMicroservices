package mentorship.roadmap.microservices.service_b.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import mentorship.roadmap.microservices.service_b.dto.MessageDto;
import mentorship.roadmap.microservices.service_b.service.RedisService;
import mentorship.roadmap.microservices.service_b.service.RestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
@Data
public class ProcessController {
    private final RedisService redisService;
    private final RestService restService;
    private final String type;

    public ProcessController(RedisService redisService, RestService restService, @Value("${app.message.important-type}")String type){
        this.redisService = redisService;
        this.restService = restService;
        this.type = type;
    }

    @PostMapping("/process")
    public ResponseEntity<Void> processMessage (@RequestBody MessageDto messageDto){
        log.info("Service B получил: {}", messageDto);

        if (type.equalsIgnoreCase(messageDto.getType())){
            redisService.save(messageDto);
        }
        restService.sendToServiceC(messageDto);
        return ResponseEntity.ok().build();
    }
}
