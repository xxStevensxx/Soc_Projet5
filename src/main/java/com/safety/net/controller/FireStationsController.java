package com.safety.net.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.safety.net.model.FireStations;
import com.safety.net.model.ListObject;
import com.safety.net.services.AddressServices;
import com.safety.net.services.FireStationsServices;


public class FireStationsController {
		
	@Autowired
	FireStationsServices fireStationServices;

	@Autowired
	AddressServices adrServices;
	

	
	@RequestMapping(value = "/person", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<List<FireStations>> addFireStations(@RequestBody FireStations fireStation){
		
		fireStationServices.addFireStations(fireStation);
		
		adrServices.addAddress(fireStation.getAddress());
		
		return new ResponseEntity<>(ListObject.listFireStations, HttpStatus.OK);
		
	}

}
