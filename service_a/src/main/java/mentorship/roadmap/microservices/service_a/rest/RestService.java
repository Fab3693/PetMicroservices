package mentorship.roadmap.microservices.service_a.rest;

import mentorship.roadmap.microservices.service_a.dto.MessageDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {
    private final RestTemplate restTemplate;
    private final String serviceBUrl;

    public RestService(RestTemplate restTemplate,
                       @Value("${service.b.url}") String serviceBUrl) {
        this.restTemplate = restTemplate;
        this.serviceBUrl = serviceBUrl;
    }

    public void sendToServiceB(MessageDto messageDto) {
        String url = serviceBUrl + "/api/process";
        restTemplate.postForEntity(url, messageDto, Void.class);
    }
}
