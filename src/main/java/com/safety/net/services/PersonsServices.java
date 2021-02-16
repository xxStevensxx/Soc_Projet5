package com.safety.net.services;

import org.springframework.stereotype.Component;

import com.safety.net.model.ListObject;
import com.safety.net.model.Persons;

@Component
public class PersonsServices {

	public boolean addPerson(Persons person) {

		return ListObject.listPersons.add(person);

	}

}
