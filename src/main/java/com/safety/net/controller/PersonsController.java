package com.safety.net.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.safety.net.model.ListObject;
import com.safety.net.model.Persons;
import com.safety.net.services.AddressServices;
import com.safety.net.services.PersonsServices;

@RestController
public class PersonsController {
	
	@Autowired
	PersonsServices personServices;

	@Autowired
	AddressServices adrServices;
	
	
	
	@RequestMapping(value = "/person", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<List<Persons>> addPersons(@RequestBody Persons person){
		
		personServices.addPerson(person);
		
		adrServices.addAddress(person.getLocation());
		
		return new ResponseEntity<>(ListObject.listPersons, HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value = "/person", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Persons>> readPersons(@RequestBody Persons person){
		
		return new ResponseEntity<>(ListObject.listPersons, HttpStatus.OK);

		
	}
	
	
	

}
