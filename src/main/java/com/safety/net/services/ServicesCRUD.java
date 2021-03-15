package com.safety.net.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.safety.net.SafetyNetApplication;
import com.safety.net.model.Address;
import com.safety.net.model.FireStations;
import com.safety.net.model.ListObject;
import com.safety.net.model.Persons;
import com.safety.net.util.CentralizedMsg;
import com.safety.net.util.DateManager;

@Component
public class ServicesCRUD {
	
	@Autowired
	DateManager dateManager;
	
	@Autowired
	CentralizedMsg msg;
	
	
	
//	************************** Services Persons ****************************
	
	public boolean addPerson(Persons person) {

		SafetyNetApplication.LOG.info(msg.logManager(0));
		
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
		
		SafetyNetApplication.LOG.info(ListObject.listPersons.get(iterator).getFirstName() + msg.logManager(1));
		
			return ListObject.listPersons;

	}
	
	
	public Persons removePerson(int iterator) {
		
		SafetyNetApplication.LOG.info(ListObject.listPersons.get(iterator).getFirstName() + msg.logManager(2));
		
			return	ListObject.listPersons.remove(iterator);

	}
	
	
//	************************** Services FireStations ****************************
	
	

	
	public boolean addFireStations(FireStations fireStation) {
		
		SafetyNetApplication.LOG.info(msg.logManager(3));

			return ListObject.listFireStations.add(fireStation);

	}
	
	
	public List<FireStations> updateFireStation(FireStations fireStation, int iterator){
	
			
			if (fireStation.getAddress() != null || fireStation.getAddress().toString() != "") {
				
				ListObject.listFireStations.get(iterator).setStation(fireStation.getStation());
				ListObject.listFireStations.get(iterator).setAddress(fireStation.getAddress());
				
			}
				
		SafetyNetApplication.LOG.info(" La station de pompier N* : " + ListObject.listFireStations.get(iterator).getStation() +
				" à L'adresse :  " + ListObject.listFireStations.get(iterator).getAddress().getAddress() + msg.logManager(1));

			return ListObject.listFireStations;
		
	}
	
	
	
	public FireStations removeFireStation(int iterator) {
		
		SafetyNetApplication.LOG.info("La station de pompier N* : " + ListObject.listFireStations.get(iterator).getStation() +
				" à l'adresse : " + ListObject.listFireStations.get(iterator).getAddress().getAddress() + msg.logManager(2));
		
			return	ListObject.listFireStations.remove(iterator);

}
	
	
//	************************** Services Address ****************************

	

	public boolean addAddress(Address address) {
		
		SafetyNetApplication.LOG.info(msg.logManager(4));
		
			return ListObject.listAddress.add(address);

	}

	
	

}
