package com.safety.net.services;

import java.util.ArrayList;
import java.util.List;

import com.safety.net.model.FireStations;
import com.safety.net.model.ListObject;

//import com.safety.net.model.Address;

import com.safety.net.model.MedicalRecords;
import com.safety.net.model.Persons;



public class DisplayInfo {
	
	Persons persons;
	String LastName;
	String firstName;
	String address;
	String city;
	String zip;
	int phone;
	String email;
	int station;
	
	
	public List<Persons> displayAllPersons(){
		
		return  ListObject.listPersons;
	}
	
	
	
	public List<String> displayPerson(int id){
		
		List<String> listOfThisPerson = new ArrayList<>();
		
		LastName = ListObject.listPersons.get(id).getLastName();
		firstName = ListObject.listPersons.get(id).getFirstName(); 
		address = ListObject.listPersons.get(id).getLocation().getAddress();
		city = ListObject.listPersons.get(id).getLocation().getCity();
		zip = ListObject.listPersons.get(id).getLocation().getZip();
		phone = ListObject.listPersons.get(id).getPhone();
		email = ListObject.listPersons.get(id).getEmail();
		
		
		listOfThisPerson.add(LastName);
		listOfThisPerson.add(firstName);
//		listOfThisPerson.add(address);
//		listOfThisPerson.add(city);
//		listOfThisPerson.add(zip);
		listOfThisPerson.add(email);
		
				return listOfThisPerson;

		
	}
	
	
	public List<Object> displayStation(int id){
		
		List<Object> listOfThisStation = new ArrayList<>();
		
		station = ListObject.listFireStations.get(id).getStation();
		address = ListObject.listAddress.get(id).getAddress();
		
		
		listOfThisStation.add(station);
		listOfThisStation.add(address);
		
		return listOfThisStation;

		
	}
	
	 
	public List<FireStations> displayAllStation() {
		
		
		return  ListObject.listFireStations;
	}

	
	public List<MedicalRecords> displayAllMedicalRecords() {
		
		return ListObject.listMedicalRecords;

	}
}
