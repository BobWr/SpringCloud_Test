/*********************************************
 * UserControllerTest.java
 * Author: bjk
 * Created on: 2018年7月9日
 ********************************************/
/**
 *
 */
package com.jkm.controllerTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import junit.framework.Assert;

/*********************************************
 * UserControllerTest.java Author: jkbao Created on: 2018年7月9日
 ********************************************/
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getUser() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/crud/user/1"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		Assert.assertNotNull(result.getModelAndView().getModel());
	}

	@Test
	public void getUserList() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/crud/user"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		Assert.assertNotNull(result.getModelAndView().getModel());
	}

	@Test
	public void add() throws Exception {
		String requestBody = "{\"id\":3, \"username\":\"cc\", \"password\":\"cc\"}";
		
		mockMvc.perform(MockMvcRequestBuilders.post("/crud/user")
				.contentType(MediaType.APPLICATION_JSON).content(requestBody)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}
	
	@Test
	public void update() throws Exception {
		String requestBody = "{\"id\":3, \"username\":\"cc\", \"password\":\"cc\"}";
		
		mockMvc.perform(MockMvcRequestBuilders.put("/crud/user")
				.contentType(MediaType.APPLICATION_JSON).content(requestBody)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}
	
	@Test
	public void delete() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.delete("/crud/user/3"))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}
}
