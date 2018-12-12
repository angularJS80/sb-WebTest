package cho.me.springwebtest;

import com.jayway.jsonpath.internal.JsonContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class JsonTest {
    @Autowired
    JacksonTester<JackTestDto> jacksonTester;

    @Test
    public void testJson() throws IOException {
        JackTestDto jackTestDto = new JackTestDto();
        jackTestDto.setName("name");
        JsonContext jsonContext = json.write(jackTestDto);
        assertThat(this.json.write(jsonContext).)
    }
}
