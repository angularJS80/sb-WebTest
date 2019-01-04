package cho.me.springwebtest.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateClientService {
    RestTemplate restTemplate;

    public RestTemplateClientService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getOtherServerCall(){
        return restTemplate.getForObject("/",String.class);
    }
}

