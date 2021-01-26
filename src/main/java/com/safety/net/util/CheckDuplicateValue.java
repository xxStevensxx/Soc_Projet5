package com.safety.net.util;



import org.springframework.stereotype.Service;

import com.safety.net.model.Address;
import com.safety.net.model.ListObject;
import com.safety.net.model.Persons;

@Service
public class CheckDuplicateValue {
	
	
	
	
	public Address checkAdr(String adr) {
	
		Address	address = ListObject.listAddress.stream()
				.filter(predicate -> predicate.getAddress().equals(adr))
				.findAny().orElse(null);		
	
					return address;
		
	}
	
	
	public Persons checkPerson(String firstName, String lastName) {
		
		
		Persons	person = ListObject.listPersons.stream()
				.filter(predicate -> predicate.getFirstName().equals(firstName) &&
						predicate.getLastName().equals(lastName))
				.findAny().orElse(null) ;	
		
		
					return person;
		
	}

}
