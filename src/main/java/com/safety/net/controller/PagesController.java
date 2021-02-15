package com.safety.net.controller;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


<<<<<<< Updated upstream
import com.safety.net.model.FireStations;
import com.safety.net.model.Persons;
=======

>>>>>>> Stashed changes
import com.safety.net.services.DisplayInfo;
import com.safety.net.services.ListConstruct;

@RestController
public class PagesController {
	
<<<<<<< Updated upstream
	DisplayInfo displayInfo = new DisplayInfo();
=======
	
	@Autowired
	DisplayInfo displayInfo;
>>>>>>> Stashed changes
	
	@Autowired
	ListConstruct listConstruct;
	
	
	@RequestMapping("/")
	public String home() {
		
		return "Welcome to Safety Net!";
	}
	
<<<<<<< Updated upstream
	@RequestMapping("/infoPersons")
	public List<Persons> infoPersons() throws FileNotFoundException, IOException {
				
			return  displayInfo.displayAllPersons();
=======
	

	@RequestMapping(value = "/firestation", method = RequestMethod.GET, produces = "application/json" )
	public String fireStations(@RequestParam(name = "stationNumber", required = true) int id){
		
		return displayInfo.displayPplNearStation(id).toString();
		
	}
	
	@RequestMapping(value = "/childAlert", method = RequestMethod.GET, produces = "application/json")
	public String childAlert(@RequestParam(name = "address", required = true) String address){
		
		return displayInfo.childAlert(address).toString();
		
>>>>>>> Stashed changes
	}
	
	@RequestMapping(value = "/phoneAlert", method = RequestMethod.GET, produces = "application/json")
	public String phoneAlert(@RequestParam(name = "firestation", required = true) int fireStationNumber){
		
		return displayInfo.phoneAlert(fireStationNumber).toString();
		
	}
	
<<<<<<< Updated upstream
	@RequestMapping("/infoFireStations")
	public List<FireStations> infoFireStations() throws FileNotFoundException, IOException {
=======
	@RequestMapping(value = "/fire", method = RequestMethod.GET, produces = "application/json")
	public String fire(@RequestParam(name = "address", required = true) String address){
		
		return displayInfo.fireAdr(address).toString();
>>>>>>> Stashed changes
		
	}
	
	@RequestMapping(value = "/flood/stations", method = RequestMethod.GET, produces = "application/json")
	public String flood(@RequestParam(name = "stations", required = true) List<Integer> stations){
		
		return displayInfo.flood(stations).toString();
		
	}
	
<<<<<<< Updated upstream
	@RequestMapping("/infoFireStations/{id}")
	public List<Object> infoFireStation(@PathVariable int id) throws FileNotFoundException, IOException {
=======
	@RequestMapping(value = "/personInfo", method = RequestMethod.GET, produces = "application/json")
	public String personInfo(@RequestParam(name = "firstName", required = true) String firstName, 
			@RequestParam(name = "lastName", required = true) String lastName){
		
		return displayInfo.personInfo(firstName, lastName).toString();
>>>>>>> Stashed changes
		
	}
<<<<<<< Updated upstream

=======
	
	
	@RequestMapping(value = "/communityEmail", method = RequestMethod.GET, produces = "application/json")
	public String communityEmail(@RequestParam(name = "city", required = true) String  city){
		
		return displayInfo.communityEmail(city).toString();
		
	}
>>>>>>> Stashed changes
	
}



















//@RequestMapping(value = "/toto")
//public ResponseEntity<List<Persons>> fireStationsTest(){
//	
//	
//	JsonObject result = new JsonObject();
//	Persons p = new Persons();
//	
//	
//	p.setFirstName("TOTOSet");
//	
//	result.addProperty("name", "TOTO");
//	result.addProperty("age", 27);
//	
//	return  new ResponseEntity<>(ListObject.listPersons , HttpStatus.OK);
//	
//}