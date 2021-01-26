package com.safety.net.services;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.safety.net.model.ListObject;
import com.safety.net.model.Persons;

public class ListConstructTest {

	DataReader dataReaderTest = new DataReader();
	ListObject listObject = new ListObject();

	@Test
	public void constructPersonsTest() throws FileNotFoundException, IOException {

		// WHEN
		String actual = null;
		JsonObject jsonFile = dataReaderTest.readFile("src/main/resources/data.json");
		JsonArray jsonArray = jsonFile.getAsJsonArray("persons");

		// GIVEN
		for (int iterator = 0; iterator < jsonArray.size(); iterator++) {
			Persons person = new Persons();
			JsonObject jsonObject = jsonArray.get(iterator).getAsJsonObject();

			person.setFirstName(jsonObject.get("firstName").getAsString());
		 	ListObject.listPersons.add(person);
		 	
					
			actual = person.getFirstName();

		}
		
		
		// THEN
		assertEquals("Eric", actual);

	}

}
