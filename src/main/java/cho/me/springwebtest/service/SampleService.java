package cho.me.springwebtest.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SampleService {
    RestTemplate restTemplate;

    public SampleService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();

    }

    public String getName(){
        return restTemplate.getForObject("/foo",String.class);
    }
}






