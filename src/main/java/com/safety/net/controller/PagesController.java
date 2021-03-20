package com.safety.net.controller;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safety.net.services.DisplayInfo;
import com.safety.net.services.ListConstruct;
import com.safety.net.util.FilterJcksn;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
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
	
//	<util:properties id="messageProperties" location="/messages.properties"/>


	@RequestMapping(value = "/firestation", method = RequestMethod.GET, produces = "application/json" )
	public ResponseEntity<MappingJacksonValue> fireStations (@RequestParam(name = "stationNumber", required = true) int id){
				
		return new ResponseEntity<MappingJacksonValue>(filterJcksn.pplNearStationFilter
				(displayInfo.displayPplNearStationBis(id)), HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/childAlert", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<MappingJacksonValue> childAlert(@RequestParam(name = "address", required = true) String address){
		
		return new ResponseEntity<MappingJacksonValue>(filterJcksn.childAlertFilter
				(displayInfo.childAlert(address)), HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/phoneAlert", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<MappingJacksonValue> phoneAlert(@RequestParam(name = "firestation", required = true) int fireStationNumber){
		
		return new ResponseEntity<MappingJacksonValue>(filterJcksn.phoneAlertFilter
				(displayInfo.phoneAlert(fireStationNumber)), HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/fire", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<MappingJacksonValue> fire(@RequestParam(name = "address", required = true) String address){
		
		return new ResponseEntity<MappingJacksonValue>(filterJcksn.fireAdrFilter
				(displayInfo.fireAdr(address)), HttpStatus.OK);

  }
	
	@RequestMapping(value = "/flood/stations", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<MappingJacksonValue> flood(@RequestParam(name = "stations", required = true) ArrayList<Integer> stations){
		
		return new ResponseEntity<MappingJacksonValue>(filterJcksn.floodFilter
				(displayInfo.flood(stations)), HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/personInfo", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<MappingJacksonValue> personInfo(@RequestParam(name = "firstName", required = true) String firstName, 
			@RequestParam(name = "lastName", required = true) String lastName){
		
		return new ResponseEntity<MappingJacksonValue>(filterJcksn.personInfoFilter
				(displayInfo.personInfo(firstName, lastName)), HttpStatus.OK);
		
	}

	
	@RequestMapping(value = "/communityEmail", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<MappingJacksonValue> communityEmail(@RequestParam(name = "city", required = true) String  city){
		
		return new ResponseEntity<MappingJacksonValue>(filterJcksn.communityEmailFilter
				(displayInfo.communityEmail(city)),HttpStatus.OK);
		
	}

}











