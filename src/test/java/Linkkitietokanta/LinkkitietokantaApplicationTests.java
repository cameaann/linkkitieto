package Linkkitietokanta;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class LinkkitietokantaApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Test
	void addLink_should_return_302_when_title_is_valid() throws Exception {
		mockMvc.perform(post("/?title=myLink"))
				.andExpect(status().is(302));

		mockMvc.perform(get("/"))
				.andExpect(status().isOk())
				.andExpect(content().string(Matchers.containsString("myLink")));
	}

	@Test
	void showList_should_return_200() throws Exception {
		mockMvc.perform(get("/"))
				.andExpect(status().isOk());
	}
}
