package cho.me.springwebtest;

import cho.me.springwebtest.service.RestTemplateClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class IndexController {
    @Autowired
    RestTemplateClientService restTemplateClientService;

    @GetMapping("/")
    public String getIndex() {
        return restTemplateClientService.getOtherServerCall();
        //return "Hello World";
    }
}
