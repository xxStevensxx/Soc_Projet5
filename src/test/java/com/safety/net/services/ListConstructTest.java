package com.safety.net.services;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;

import com.google.gson.JsonObject;

import com.safety.net.model.ListObjectTest;
import com.safety.net.util.CheckDuplicateValue;

public class ListConstructTest {

	DataReader dtrTest = new DataReader();

	CheckDuplicateValue checkDuplicateValue = new CheckDuplicateValue();

	ListConstruct listConstruct = new ListConstruct();
	

	@BeforeEach
	public void init() {

		JsonObject jsonFile = dtrTest.readFile("src/main/resources/test.json");
		listConstruct.jsonFile = jsonFile;
		listConstruct.listPers = ListObjectTest.listPersonsTest;
		listConstruct.listFir = ListObjectTest.listFireStationsTest;
		listConstruct.listMed = ListObjectTest.listMedicalRecordsTest;
		listConstruct.checkDuplicateValue = checkDuplicateValue;

	}
	
	

//	@Test
	public void constructPersonsTest() {

		// WHEN
		listConstruct.constructPerson();
		int expected = ListObjectTest.listPersonsTest.size();

		// GIVEN

		// THEN
		assertEquals(expected, 5);

	}

//	@Test
	public void constructFireStationTest() {
		
		//WHEN
		listConstruct.constructFireStations();
		int expected = ListObjectTest.listFireStationsTest.size();
		
		
		//GIVEN
		
		
		//THEN
		assertEquals(expected, 7);

		
	} 
	
	
//	@Test
	public void constructMedicalRecordTest() {
		
		//WHEN
		listConstruct.constructMedicalRecords();
		int expected = ListObjectTest.listMedicalRecordsTest.size();
		
		
		//GIVEN
		
		
		//THEN
		assertEquals(expected, 5);

		
	} 

}
