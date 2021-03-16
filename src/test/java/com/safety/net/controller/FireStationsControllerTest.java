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
public class FireStationsControllerTest {
	
	private final String fireStationString1 = "{\r\n"
			+ "    \"station\": 7,\r\n"
			+ "    \"address\":{\"address\":\"Naboo\",\"city\":\"deathStartSt\", \"zip\":\"00000\"}\r\n"
			+ "}";
	
	private final String fireStationString2 = "{\r\n"
			+ "    \"station\": 9,\r\n"
			+ "    \"address\":{\"address\":\"Tatooine\",\"city\":\"Jedi st\", \"zip\":\"55555\"}\r\n"
			+ "}";
	

	@Autowired
	private MockMvc mockMvc;	

	@Test
	public void addFireStationTest() throws Exception {
		
		
		//WHEN
		
		//GIVEN
		
		//THEN
		mockMvc.perform(post("/firestationAPI").contentType(MediaType.APPLICATION_JSON)
				.content(fireStationString1))
			//	.andDo(print())
				.andExpect(status().isCreated())
		
					.andExpect(jsonPath("$[-1].station", is(7)));
		
	}
	
	
	@Test
	public void readAllFireStationTest() throws Exception {
		
		
		//WHEN
		
		//GIVEN
		
		//THEN
		mockMvc.perform(get("/AllFireStations").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isFound())
		
					.andExpect(jsonPath("$[0].station", is(9)));
		
	}
	
	
	@Test
	public void updateFireStationsTest() throws Exception {

		//WHEN
		
		//GIVEN
		
		//THEN
		mockMvc.perform(put("/firestationUpdate").param("station", "3").param("address", "1509 Culver St")
				.contentType(MediaType.APPLICATION_JSON)
				.content(fireStationString2))
			//	.andDo(print())
				.andExpect(jsonPath("$[0].station", is(9)))
				.andExpect(status().isOk());
		
			
		
	}
	
	@Test
	public void deleteFireStationsTest() throws Exception {

		//WHEN
		
		//GIVEN
		
		//THEN
		mockMvc.perform(delete("/deleteFireStation").param("station", "9").param("address", "Tatooine")
				.contentType(MediaType.APPLICATION_JSON)
				.content(fireStationString2))
				.andExpect(jsonPath("$[0].station", is(2)))
				.andExpect(status().isAccepted());
		
	}
	
	
	

}
