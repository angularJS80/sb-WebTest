package cho.me.springwebtest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
//@org.springframework.boot.test.autoconfigure.json.JsonTest
public class JsonTest {
    //@Autowired
    JacksonTester<JackTestDto> jacksonTester;

    @Before
    public void setup(){
        JacksonTester.initFields(this,new ObjectMapper());
    }
    @Test
    public void testJson() throws IOException {
        JackTestDto jackTestDto = new JackTestDto();
        jackTestDto.setName("cho");

        JsonContent<JackTestDto> jsonContent  = this.jacksonTester.write(jackTestDto);
        assertThat(jsonContent)
                .hasJsonPathStringValue("@.name")
                .extractingJsonPathStringValue("@.name").isEqualTo("cho1");
    }
}
