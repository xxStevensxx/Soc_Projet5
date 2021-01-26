package com.safety.net.controller;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.safety.net.model.FireStations;
import com.safety.net.model.Persons;
import com.safety.net.services.DisplayInfo;
import com.safety.net.services.ListConstruct;

@RestController
public class PagesController {
	
	DisplayInfo displayInfo = new DisplayInfo();
	
	@Autowired
	ListConstruct listConstruct;
	
	@RequestMapping("/")
	public String home() {
		
		return "Welcome to Safety Net!";
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
	public List<FireStations> infoFireStations() throws FileNotFoundException, IOException {
		
			return displayInfo.displayAllStation();
	}
	
	
	@RequestMapping("/infoFireStations/{id}")
	public List<Object> infoFireStation(@PathVariable int id) throws FileNotFoundException, IOException {
		
			return displayInfo.displayStation(id);
	}

	
}
