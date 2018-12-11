package cho.me.springwebtest;

import cho.me.springwebtest.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class IndexController {
    @Autowired
    IndexService indexService;

    @GetMapping("/")
    public String getIndex() {
        return indexService.getIndex();
        //return "Hello World";
    }
}
