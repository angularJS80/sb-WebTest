package cho.me.springwebtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class SpringwebtestApplicationTests {

	@Autowired
	WebTestClient webTestClient;

	@Autowired
	TestRestTemplate testRestTemplate;

	@LocalServerPort
	int localServerPort;

	@TestConfiguration // Configuration 으로 변경시 테스트가 메인이 됨으로 실제 어플리케이션에서 사용중인 빈을 주입 받을 수 없다. 주입받으려면 컴포넌트 스캔 해야함.
	static class TestConfig{
		@Bean
		public String getTestBean(){
			return "Its TestBean";
		}

	}

	@Autowired
	TestConfig testConfig;


	@Test
	public void contextLoads() throws Exception{

	}

}
