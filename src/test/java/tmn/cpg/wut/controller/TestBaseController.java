package tmn.cpg.wut.controller;

import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import tmn.cpg.wut.config.TestWebConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {TestWebConfig.class})
public class TestBaseController {

	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;
	
	@Before
	public void setUpBefore() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void welcomeNoName() throws Exception {
		ResultActions results = this.mockMvc.perform(get("/welcome/"));
		results.andExpect(status().isOk())
		.andExpect(model().attribute("message", "Maven Project + Spring Hello!"));
	}
	
	@Test
	public void welcomeWut() throws Exception {
		String name = "wut";
		ResultActions results = this.mockMvc.perform(get("/welcome/"+name));
		results.andExpect(status().isOk())
		.andExpect(model().attribute("message", "Maven Project + Spring Hello! - "+name));
	}

}
