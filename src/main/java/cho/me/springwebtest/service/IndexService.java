package cho.me.springwebtest.service;

import org.springframework.stereotype.Service;

@Service
public class IndexService {
    public String getIndex(){
        return "Hello World";
    }
}
