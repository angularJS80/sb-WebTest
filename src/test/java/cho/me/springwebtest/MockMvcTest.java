package cho.me.springwebtest;

import cho.me.springwebtest.service.IndexService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class MockMvcTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IndexService indexService;

    @Test
    public void test() throws Exception{
        System.out.println(indexService.getIndex());
        given(indexService.getIndex()).willReturn("Mock");
       mockMvc.perform(get("/"))
               .andExpect(handler().handlerType(IndexController.class))
               .andExpect(handler().methodName("getIndex"))
               .andExpect(status().isOk())
               .andExpect(content().string("cho"));

    }
}
