package com.safety.net.controller;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.safety.net.model.FireStations;
import com.safety.net.model.MedicalRecords;
import com.safety.net.model.Persons;
import com.safety.net.services.DisplayInfo;
import com.safety.net.services.ListConstruct;

@RestController
public class PagesController {
	
	@Autowired
	DisplayInfo displayInfo;
	
	@Autowired
	ListConstruct listConstruct;
	
	@RequestMapping("/")
	public String home() {
		
		return "Welcome to Safety Net!";
	}
	
	
	@RequestMapping(value = "/firestations", method = RequestMethod.GET)
	public List<String> fireStations(@RequestParam("stationNumber") int id){
		
		return displayInfo.displayPplNearStation(id);
		
	}
	
	@RequestMapping("/infoPersons")
	public List<Persons> infoPersons() throws FileNotFoundException, IOException {
				
			return  displayInfo.displayAllPersons();
	}
	
	
	@RequestMapping("/infoPersons/{id}")
	public List<String> infoPerson(@PathVariable int id){
		
		return displayInfo.displayPerson(id);
	}
	
	@RequestMapping("/infoFireStations")
	public List<FireStations> infoFireStations(){
		
			return displayInfo.displayAllStation();
	}
	
	
	@RequestMapping("/infoFireStations/{id}")
	public List<Object> infoFireStation(@PathVariable int id) {
		
			return displayInfo.displayStation(id);
	}
	
	@RequestMapping("/infoMedicalRecords")
	public List<MedicalRecords> infoFireStation() {
		
			return displayInfo.displayAllMedicalRecords();
	}
	
}
