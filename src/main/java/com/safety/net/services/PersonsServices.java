package com.safety.net.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.safety.net.model.ListObject;
import com.safety.net.model.Persons;
import com.safety.net.util.DateManager;

@Component
public class PersonsServices {
	
	
	@Autowired
	DateManager dateManager;

	public boolean addPerson(Persons person) {

		return ListObject.listPersons.add(person);

	}

	public List<Persons> updatePerson(Persons person, int iterator) {

		if (person.getFirstName() != null && person.getFirstName() != "") {

			ListObject.listPersons.get(iterator).setFirstName(person.getFirstName());

		}
		
		if (person.getLastName() != null && person.getLastName() != "") {

			ListObject.listPersons.get(iterator).setLastName(person.getLastName());

		}
		
		if (person.getPhone() != null && person.getPhone() != "") {

			ListObject.listPersons.get(iterator).setPhone(person.getPhone());

		}
		
		if (person.getEmail() != null && person.getEmail() != "") {

			ListObject.listPersons.get(iterator).setEmail(person.getEmail());

		}
		
		if (person.getLocation() != null && person.getLocation().toString() != "") {

			ListObject.listPersons.get(iterator).setLocation(person.getLocation());

		}
		
		if (person.getMedicalRecord() != null && person.getMedicalRecord().toString() != "") {

			ListObject.listPersons.get(iterator).setMedicalRecord(person.getMedicalRecord());

		}
		
		if (person.getBirthDate() != null && person.getBirthDate().toString() != "") {
			
			LocalDate date = person.getBirthDate();
			String age = dateManager.calculateAge(date.toString());
			
			ListObject.listPersons.get(iterator).setAge(Integer.parseInt(age));

			ListObject.listPersons.get(iterator).setBirthDate(person.getBirthDate());

		}

		return ListObject.listPersons;

	}

}
