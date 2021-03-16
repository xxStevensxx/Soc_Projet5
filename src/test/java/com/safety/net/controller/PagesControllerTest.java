package com.safety.net.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class PagesControllerTest {
	
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	public void firestationsTest() throws Exception {
		
		
		//WHEN
		
		//GIVEN
		
		//THEN
		mockMvc.perform(get("/firestation").param("stationNumber", "2")).andExpect(status().isOk());
		
	}
	
	
	@Test
	public void childAlertTest() throws Exception {
		
		
		//WHEN
		
		//GIVEN
		
		//THEN
		mockMvc.perform(get("/childAlert").param("address", "1509 Culver St")).andExpect(status().isOk());
		
	}
	
	@Test
	public void phoneAlertTest() throws Exception {
		
		
		//WHEN
		
		//GIVEN
		
		//THEN
		mockMvc.perform(get("/phoneAlert").param("firestation", "2")).andExpect(status().isOk());
		
	}
	
	@Test
	public void fireTest() throws Exception {
		
		
		//WHEN
		
		//GIVEN
		
		//THEN
		mockMvc.perform(get("/fire").param("address", "1509 Culver St")).andExpect(status().isOk());
		
	}
	
	@Test
	public void floodTest() throws Exception {
		
		
		//WHEN
		
		//GIVEN
		
		//THEN
		mockMvc.perform(get("/flood/stations").param("stations", "2")).andExpect(status().isOk());
		
	}
	
	@Test
	public void personInfoTest() throws Exception {
		
		
		//WHEN
		
		//GIVEN
		
		//THEN
		mockMvc.perform(get("/personInfo").param("firstName", "John").param("lastName", "Boyd")).andExpect(status().isOk());
		
	}
	
	@Test
	public void communityEmailTest() throws Exception {
		
		
		//WHEN
		
		//GIVEN
		
		//THEN
		mockMvc.perform(get("/communityEmail").param("city", "Culver")).andExpect(status().isOk());
		
	}
	
	
	
	
	
	
}
