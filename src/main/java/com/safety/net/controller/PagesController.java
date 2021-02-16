package com.safety.net.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.safety.net.services.DisplayInfo;
import com.safety.net.services.ListConstruct;
import com.safety.net.util.FilterJcksn;

@RestController
public class PagesController {

	@Autowired
	DisplayInfo displayInfo;

	@Autowired
	ListConstruct listConstruct;
	
	@Autowired
	FilterJcksn filterJcksn;

	@RequestMapping("/")
	public String home() {

		return "Welcome to Safety Net!";
	}
	
	
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json" )
	public  MappingJacksonValue test(){
		
		return filterJcksn.pplNearStationFilter(displayInfo.test());
		
	}


	@RequestMapping(value = "/firestation", method = RequestMethod.GET, produces = "application/json" )
	public ResponseEntity<String> fireStations (@RequestParam(name = "stationNumber", required = true) int id){
		
		return new ResponseEntity<>(displayInfo.displayPplNearStation(id).toString(), HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/childAlert", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> childAlert(@RequestParam(name = "address", required = true) String address){
		
		return new ResponseEntity<>(displayInfo.childAlert(address).toString(), HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/phoneAlert", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> phoneAlert(@RequestParam(name = "firestation", required = true) int fireStationNumber){
		
		return new ResponseEntity<>(displayInfo.phoneAlert(fireStationNumber).toString(), HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/fire", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> fire(@RequestParam(name = "address", required = true) String address){
		
		return new ResponseEntity<String>(displayInfo.fireAdr(address).toString(), HttpStatus.OK);

  }
	@RequestMapping(value = "/flood/stations", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> flood(@RequestParam(name = "stations", required = true) int stations){
		
		return new ResponseEntity<String>(displayInfo.flood(stations).toString(), HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/personInfo", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> personInfo(@RequestParam(name = "firstName", required = true) String firstName, 
			@RequestParam(name = "lastName", required = true) String lastName){
		
		return new ResponseEntity<String>(displayInfo.personInfo(firstName, lastName).toString(), HttpStatus.OK);
		
	}

	
	@RequestMapping(value = "/communityEmail", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> communityEmail(@RequestParam(name = "city", required = true) String  city){
		
		return new ResponseEntity<String>(displayInfo.communityEmailBis(city).toString(), HttpStatus.OK);
		
	}

}











