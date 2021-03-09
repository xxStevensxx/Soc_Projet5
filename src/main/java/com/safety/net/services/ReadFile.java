
package com.safety.net.services;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ReadFile {
	
//	choose and read file here
	
	DataReader dtr = new DataReader();
	
	public JsonObject readPersons() throws FileNotFoundException, IOException {
		
				
		 JsonObject personsResult = null;
		
		JsonObject jsonFile = dtr.readFile("src/main/resources/data.json");
		JsonArray jsonArray = jsonFile.getAsJsonArray("persons");
		
		for (int iterator = 0; iterator < jsonArray.size(); iterator++) {
			JsonObject jsonObject = jsonArray.get(iterator).getAsJsonObject();
				
			personsResult = jsonObject;

		}
		
				return personsResult;
	}
	
	public JsonObject readFireStations() throws FileNotFoundException, IOException {
		
		JsonObject fireStationsResult = null;
		
		JsonObject jsonFile = dtr.readFile("src/main/resources/data.json");
		JsonArray jsonArray = jsonFile.getAsJsonArray("firestations");
		
		for (int iterator = 0; iterator < jsonArray.size(); iterator++) {
			JsonObject jsonObject = jsonArray.get(iterator).getAsJsonObject();
				
			fireStationsResult = jsonObject;
		}
		
				return fireStationsResult;
	}
	
	
	public JsonObject readMedicalRecords() throws FileNotFoundException, IOException {
		
		JsonObject medicalRecordsResult = null;
		
		JsonObject jsonFile = dtr.readFile("src/main/resources/data.json");
		JsonArray jsonArray = jsonFile.getAsJsonArray("medicalrecords");
		
		for (int iterator = 0; iterator < jsonArray.size(); iterator++) {
			JsonObject jsonObject = jsonArray.get(iterator).getAsJsonObject();
				
			medicalRecordsResult = jsonObject;
		}
		
				return medicalRecordsResult;
	}
	
	

}
