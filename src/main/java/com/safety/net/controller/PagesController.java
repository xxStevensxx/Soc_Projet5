package com.safety.net.controller;

<<<<<<< Updated upstream

import java.io.FileNotFoundException;
import java.io.IOException;
=======
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
	
=======

	@Autowired
	DisplayInfo displayInfo;

>>>>>>> Stashed changes
	@Autowired
	ListConstruct listConstruct;
<<<<<<< Updated upstream
	
=======

>>>>>>> Stashed changes
	@RequestMapping("/")
	public String home() {

		return "Welcome to Safety Net!";
	}
<<<<<<< Updated upstream
	
	
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
	
=======

	@RequestMapping(value = "/firestation", method = RequestMethod.GET, produces = "application/json")
	public String fireStations(@RequestParam(name = "stationNumber", required = true) int id) {

		return displayInfo.displayPplNearStation(id).toString();

	}

	@RequestMapping(value = "/childAlert", method = RequestMethod.GET, produces = "application/json")
	public String childAlert(@RequestParam(name = "address", required = true) String address) {

		return displayInfo.childAlert(address).toString();

	}

	@RequestMapping(value = "/phoneAlert", method = RequestMethod.GET, produces = "application/json")
	public String phoneAlert(@RequestParam(name = "firestation", required = true) int fireStationNumber) {

		return displayInfo.phoneAlert(fireStationNumber).toString();

	}

	@RequestMapping(value = "/fire", method = RequestMethod.GET, produces = "application/json")
	public String fire(@RequestParam(name = "address", required = true) String address) {

		return displayInfo.fireAdr(address).toString();

	}

	@RequestMapping(value = "/flood/stations", method = RequestMethod.GET, produces = "application/json")
	public String flood(@RequestParam(name = "stations", required = true) List<Integer> stations) {

		return displayInfo.flood(stations).toString();

	}

	@RequestMapping(value = "/personInfo", method = RequestMethod.GET, produces = "application/json")
	public String personInfo(@RequestParam(name = "firstName", required = true) String firstName,
			@RequestParam(name = "lastName", required = true) String lastName) {

		return displayInfo.personInfo(firstName, lastName).toString();

	}

	@RequestMapping(value = "/communityEmail", method = RequestMethod.GET, produces = "application/json")
	public String communityEmail(@RequestParam(name = "city", required = true) String city) {

		return displayInfo.communityEmail(city).toString();

	}

>>>>>>> Stashed changes
}
