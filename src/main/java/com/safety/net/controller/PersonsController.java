package com.safety.net.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.safety.net.SafetyNetApplication;
import com.safety.net.model.ListObject;
import com.safety.net.model.Persons;
import com.safety.net.services.ServicesCRUD;
import com.safety.net.util.CentralizedMsg;
import com.safety.net.util.DateManager;
import com.safety.net.util.FilterJcksn;

@RestController
public class PersonsController {



	@Autowired
	FilterJcksn filterJcksn;

	@Autowired
	CentralizedMsg msg;
	
	@Autowired
	ServicesCRUD crud;

	@Autowired
	DateManager dateManager;

	ArrayList<Persons> persons;
	Persons personUpdate;
	String firstName;
	String lastName;
	String email;
	LocalDate date;
	String age;
	boolean existe;
	
	
	
	

	@RequestMapping(value = "/person", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<MappingJacksonValue> addPersons(@RequestBody Persons person) {

		persons = new ArrayList<>();

		for (int i = 0; i < ListObject.listPersons.size(); i++) {

			persons.add(ListObject.listPersons.get(i));

			existe = false;

			firstName = ListObject.listPersons.get(i).getFirstName().toLowerCase();
			lastName = ListObject.listPersons.get(i).getLastName().toLowerCase();
			email = ListObject.listPersons.get(i).getEmail().toLowerCase();

			if (firstName.contains(person.getFirstName().toLowerCase().replaceAll("\\s", ""))
					&& lastName.contains(person.getLastName().toLowerCase().replaceAll("\\s", ""))) {

				existe = true;
				SafetyNetApplication.LOG.info(msg.logManager(12) + firstName + " " + lastName);
					return new ResponseEntity<MappingJacksonValue>(filterJcksn.filterMsg(msg.msgManager(1)),
						HttpStatus.CONFLICT);

			} else if (email.contains(person.getEmail().toLowerCase().replaceAll("\\s", ""))) {

				existe = true;
				SafetyNetApplication.LOG.info(msg.logManager(13) + email);
					return new ResponseEntity<MappingJacksonValue>(filterJcksn.filterMsg(msg.msgManager(2)),
						HttpStatus.CONFLICT);

			}

		}

		if (existe == false) {

			if (person.getBirthDate() != null) {

				date = person.getBirthDate();
				age = dateManager.calculateAge(date.toString());

				person.setAge(Integer.parseInt(age));
				person.setBirthDate(date);

			}

			crud.addPerson(person);

			crud.addAddress(person.getLocation());

			persons.add(person);
		}

		return new ResponseEntity<MappingJacksonValue>(filterJcksn.genericFilterPerson(persons), HttpStatus.CREATED);

	}

	@ResponseBody
	@RequestMapping(value = "/AllPersons", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<MappingJacksonValue> readAllPersons() {
		
		SafetyNetApplication.LOG.info(msg.logManager(14));
			return new ResponseEntity<MappingJacksonValue>(filterJcksn.genericFilterPerson(ListObject.listPersons),
				HttpStatus.FOUND);

	}
	
	
	
	

	@ResponseBody
	@RequestMapping(value = "/person", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<MappingJacksonValue> readPersons(
			@RequestParam(name = "firstName", required = true) String frstName) {

		persons = new ArrayList<>();

		for (int i = 0; i < ListObject.listPersons.size(); i++) {

			if (ListObject.listPersons.get(i).getFirstName().toLowerCase()
					.equals(frstName.toLowerCase().replaceAll("\\s", ""))) {

				persons.add(ListObject.listPersons.get(i));

				SafetyNetApplication.LOG.info(msg.logManager(15) + ListObject.listPersons.get(i).getFirstName() + " " + 
						ListObject.listPersons.get(i).getLastName());
					return new ResponseEntity<MappingJacksonValue>(filterJcksn.genericFilterPerson(persons), HttpStatus.FOUND);
				
			}

		}
			SafetyNetApplication.LOG.info(msg.msgManager(3));
				return new ResponseEntity<MappingJacksonValue>(filterJcksn.filterMsg(msg.msgManager(3)), HttpStatus.NOT_FOUND);

	}
	
	
	
	

	@RequestMapping(value = "/personUpdate", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<MappingJacksonValue> updatePersons(@RequestBody Persons person,
			@RequestParam(name = "firstName", required = true) String frstName,
			@RequestParam(name = "lastName", required = true) String lstName) {

		for (int i = 0; i < ListObject.listPersons.size(); i++) {

			persons = new ArrayList<>();

			persons.add(ListObject.listPersons.get(i));

			firstName = ListObject.listPersons.get(i).getFirstName().toLowerCase();
			lastName = ListObject.listPersons.get(i).getLastName().toLowerCase();
			email = ListObject.listPersons.get(i).getEmail().toLowerCase();

	

			if (firstName.contains(frstName.toLowerCase().replaceAll("\\s", ""))
					&& lastName.contains(lstName.toLowerCase().replaceAll("\\s", ""))) {

				crud.updatePerson(person, i);

				return new ResponseEntity<MappingJacksonValue>(filterJcksn.genericFilterPerson(ListObject.listPersons),
						HttpStatus.OK);

			}

		}
		
		SafetyNetApplication.LOG.info(msg.logManager(8));
			return new ResponseEntity<MappingJacksonValue>(filterJcksn.filterMsg(msg.msgManager(3)), HttpStatus.NOT_FOUND);

	}
	
	
	
	

	@ResponseBody
	@RequestMapping(value = "/deletePerson", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<MappingJacksonValue> deletePersons(
			@RequestParam(name = "firstName", required = true) String frstName,
			@RequestParam(name = "lastName", required = true) String lstName) {

		for (int iterator = 0; iterator < ListObject.listPersons.size(); iterator++) {

			persons = new ArrayList<>();

			persons.add(ListObject.listPersons.get(iterator));

			firstName = ListObject.listPersons.get(iterator).getFirstName().toLowerCase();
			lastName = ListObject.listPersons.get(iterator).getLastName().toLowerCase();

			if (firstName.contains(frstName.toLowerCase().replaceAll("\\s", ""))
					&& lastName.contains(lstName.toLowerCase().replaceAll("\\s", ""))) {
				
				
				crud.removePerson(iterator);


				return new ResponseEntity<MappingJacksonValue>(filterJcksn.genericFilterPerson(ListObject.listPersons),
						HttpStatus.ACCEPTED);

			}

		}
		
		SafetyNetApplication.LOG.info(msg.msgManager(3));
			return new ResponseEntity<MappingJacksonValue>(filterJcksn.filterMsg(msg.msgManager(3)), HttpStatus.NOT_FOUND);

	}

}
