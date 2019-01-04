package cho.me.springwebtest;

import cho.me.springwebtest.service.RestTemplateClientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@RestClientTest(RestTemplateClientService.class)
public class RestTemplateDiTest {

    @Autowired
    MockRestServiceServer mockRestServiceServer;

    @Autowired
    RestTemplateClientService restTemplateClientService;
    @Test
    public void test() throws IOException {
        mockRestServiceServer.expect(requestTo("/"))
                .andRespond(withSuccess("cho", MediaType.TEXT_PLAIN));

        String response = restTemplateClientService.getOtherServerCall();
        assertThat(response).isEqualTo("cho");
    }
}
