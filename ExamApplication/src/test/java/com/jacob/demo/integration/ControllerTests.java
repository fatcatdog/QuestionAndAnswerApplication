package com.jacob.demo.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.jacob.demo.controller.JwtAuthenticationController;
import com.jacob.demo.controller.QuestionController;
import com.jacob.demo.service.JwtUserDetailsService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTests {

	@Autowired
    private MockMvc mockMvc;

	@Autowired
    private QuestionController controller;
	
	@Test
	public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
	}
	
	@Test
    public void checkIfControllerReturnsOkAtRoutes() throws Exception {
        this.mockMvc.perform(get("/question/all")).andDo(print()).andExpect(status().isUnauthorized());
	}

}
