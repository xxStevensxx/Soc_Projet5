package com.safety.net.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonsControllerTest {
	
	@Autowired
	private MockMvc mockMvc;	
	
	
	private final String personString1 = "{\r\n"
			+ "			\"firstName\": \"quiGon\",\r\n"
			+ "			\"lastName\": \"jinn\",\r\n"
			+ "			\"address\": \"jedi st\",\r\n"
			+ "			\"city\": \"coruscant\",\r\n"
			+ "			\"zip\": \"1111\",\r\n"
			+ "			\"phone\": \"123-456-7890\",\r\n"
			+ "			\"email\": \"jedi@email.com\"\r\n"
			+ "		}";
	
	private final String personString2 = "{\r\n"
			+ "			\"firstName\": \"Darth\",\r\n"
			+ "			\"lastName\": \"Sidious\",\r\n"
			+ "			\"address\": \"jedi st\",\r\n"
			+ "			\"city\": \"Naboo\",\r\n"
			+ "			\"zip\": \"55555\",\r\n"
			+ "			\"phone\": \"123-456-7890\",\r\n"
			+ "			\"email\": \"sith@email.com\"\r\n"
			+ "		}";

	@Test
	public void addPersonTest() throws Exception {
		
		
		//WHEN
		
		//GIVEN
		
		//THEN
		mockMvc.perform(post("/person").contentType(MediaType.APPLICATION_JSON)
				.content(personString1))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$[-1].firstName", is("quiGon")));
		
	}
	
	@Test
	public void readAllPersonsTest() throws Exception {
		
		
		//WHEN
		
		//GIVEN
		
		//THEN
		mockMvc.perform(get("/AllPersons").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isFound())
				.andExpect(jsonPath("$[-1].firstName", is("quiGon")));
		
	}
	
	@Test
	public void readPersonsTest() throws Exception {
		
		
		//WHEN
		
		//GIVEN
		
		//THEN
		mockMvc.perform(get("/person").contentType(MediaType.APPLICATION_JSON)
				.param("firstName", "Darth"))
				.andExpect(status().isFound())
				.andExpect(jsonPath("$[0].firstName", is("Darth")));
		
	}
	
	
	
	@Test
	public void personUpdateTest() throws Exception {
		
		
		//WHEN
		
		//GIVEN
		
		//THEN
		mockMvc.perform(put("/personUpdate").param("firstName", "John").param("lastName", "Boyd")
				.contentType(MediaType.APPLICATION_JSON)
				.content(personString2))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].firstName", is("Darth")));
		
	}
	
	
	
	@Test
	public void deletePersonTest() throws Exception {
		
		
		//WHEN
		
		//GIVEN
		
		//THEN
		mockMvc.perform(delete("/deletePerson").param("firstName", "Darth").param("lastName", "Sidious")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isAccepted())
				.andExpect(jsonPath("$[0].firstName", is("Jacob")));
		
	}
	
	
	
	
	
	

}
