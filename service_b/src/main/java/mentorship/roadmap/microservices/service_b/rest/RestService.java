package mentorship.roadmap.microservices.service_b.rest;

import mentorship.roadmap.microservices.service_b.dto.MessageDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {
    private final RestTemplate restTemplate;
    private final String serviceCUrl;

    public RestService(RestTemplate restTemplate,
                       @Value("${service.c.url}") String serviceCUrl) {
        this.restTemplate = restTemplate;
        this.serviceCUrl = serviceCUrl;
    }

    public void sendToServiceC(MessageDto messageDto) {
        String url = serviceCUrl + "/api/save";
        restTemplate.postForEntity(url, messageDto, Void.class);
    }
}
