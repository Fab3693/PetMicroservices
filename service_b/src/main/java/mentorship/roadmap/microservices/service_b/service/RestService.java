package mentorship.roadmap.microservices.service_b.service;

import mentorship.roadmap.microservices.service_b.dto.MessageDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {
    private final RestTemplate restTemplate;
    private final String serviceCUrl;
    private final String saveUrl;

    public RestService(RestTemplate restTemplate,
                       @Value("${service.c.url}") String serviceCUrl,
                       @Value("${service-c.saveUrl}") String saveUrl){
        this.restTemplate = restTemplate;
        this.serviceCUrl = serviceCUrl;
        this.saveUrl = saveUrl;
    }

    public void sendToServiceC(MessageDto messageDto) {
        String url = serviceCUrl + saveUrl;
        restTemplate.postForEntity(url, messageDto, Void.class);
    }
}
