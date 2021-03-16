package com.safety.net.services;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

import org.json.simple.parser.ParseException;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import jdk.jfr.Name;


public class DataReaderTest {
	
	DataReader dataReader = new DataReader();

	
//	@Test
	@Name("Method visant à tester le contenu du fichier json")
	public void readFileTestContent () throws FileNotFoundException, IOException, ParseException, URISyntaxException {

		//GIVEN			
		int iterator = 0;
		JsonObject dataJson = dataReader.readFile("src/main/resources/test.json");
		JsonArray jsonArray = dataJson.getAsJsonArray("person");
		JsonObject jsonObject = jsonArray.get(iterator).getAsJsonObject();

		
		//WHEN
		String actual = jsonObject.get("firstName").toString();
		String expected = "Stevens";	
			
			
		//THEN
		assertThat(expected.contains(actual));
	}
	

//	@Test
	@Name("Method visant à tester si le fichier json n'est pas vide ")
	public void readFileTestIsEmpty () throws FileNotFoundException, IOException {

		//GIVEN		
		int iterator = 0;
		JsonObject dataJson = dataReader.readFile("src/main/resources/test.json");
		JsonArray jsonArray = dataJson.getAsJsonArray("person");
		JsonObject jsonObject = jsonArray.get(iterator).getAsJsonObject();
	
		//WHEN
		String expected = jsonObject.toString();
		boolean actual = false;
				
			
		//THEN
		assertEquals(expected.isEmpty(), actual);
		
	}

}