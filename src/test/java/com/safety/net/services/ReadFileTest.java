package com.safety.net.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ReadFileTest {
	
	@Mock
	DataReader dataReaderTest = new DataReader();
	
	
//	@Test
	public void readPersons() throws FileNotFoundException, IOException {
		
		JsonObject actual = null;
		
		//GIVEN
		JsonObject jsonFile = dataReaderTest.readFile("src/main/resources/test.json");
		JsonArray jsonArray = jsonFile.getAsJsonArray("person");
		String expected =
				"{\"firstName\":\"Stevens\",\"lastName\":\"Tavares\",\"address\":\"Danton\",\"city\":\"Draveil\",\"zip\":\"91210\",\"phone\":\"841-874-6512\",\"email\":\"st@email.com\"}";
		
		//WHEN
		for (int iterator = 0; iterator < jsonArray.size(); iterator++) {
			JsonObject jsonObject = jsonArray.get(iterator).getAsJsonObject();
				
			actual = jsonObject;
		}
		
		//THEN
		assertThat(expected.toString().contains(actual.toString()));
	}

}
