package mentorship.roadmap.microservices.service_a.service;

import mentorship.roadmap.microservices.service_a.dto.MessageDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {
    private final RestTemplate restTemplate;
    private final String serviceBUrl;
    private final String processUrl;

    public RestService(RestTemplate restTemplate,
                       @Value("${service.b.url}") String serviceBUrl,
                       @Value("${service-b.processUrl}") String processUrl) {
        this.restTemplate = restTemplate;
        this.serviceBUrl = serviceBUrl;
        this.processUrl = processUrl;
    }

    public void sendToServiceB(MessageDto messageDto) {
        String url = serviceBUrl + processUrl;
        restTemplate.postForEntity(url, messageDto, Void.class);
    }
}
