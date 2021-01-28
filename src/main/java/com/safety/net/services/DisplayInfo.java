package com.safety.net.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.safety.net.model.FireStations;
import com.safety.net.model.ListObject;


import com.safety.net.model.MedicalRecords;
import com.safety.net.model.Persons;


@Service
public class DisplayInfo {
	
	Persons persons;
	String LastName;
	String firstName;
	String address;
	String city;
	String zip;
	String phone;
	String email;
	int station;
	String birthDate;
	ArrayList<String> allergies;
	ArrayList<String> medications;

	
	
	public List<Persons> displayAllPersons(){
		
		return  ListObject.listPersons;
	}
	
	
	
	public List<String> displayPerson(int id){
		
		List<String> listOfThisPerson = new ArrayList<>();
		
		LastName =  ListObject.listPersons.get(id).getLastName();
		firstName = ListObject.listPersons.get(id).getFirstName(); 
		phone = ListObject.listPersons.get(id).getPhone();
		birthDate = ListObject.listBirthDate.get(id).getBirthDate().toString();
		address = ListObject.listPersons.get(id).getLocation().getAddress();
		city = ListObject.listPersons.get(id).getLocation().getCity();
		zip = ListObject.listPersons.get(id).getLocation().getZip();
		phone = ListObject.listPersons.get(id).getPhone();
		email = ListObject.listPersons.get(id).getEmail();
		allergies = (ArrayList<String>) ListObject.listMedicalRecords.get(id).getAllergies();
		medications = (ArrayList<String>) ListObject.listMedicalRecords.get(id).getMedications();
		
		
		listOfThisPerson.add(LastName);
		listOfThisPerson.add(firstName);
		listOfThisPerson.add(birthDate);
		listOfThisPerson.add(phone);
		listOfThisPerson.add(address);
		listOfThisPerson.add(city);
		listOfThisPerson.add(zip);
		listOfThisPerson.add(email);
		listOfThisPerson.addAll(allergies);
		listOfThisPerson.addAll(medications);
		
		
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
	
	
	public List<String> displayPplNearStation(int id) {
		
		List<String> listPplNearFstationRtrn = null;
		String fStationAdr = ListObject.listFireStations.get(id).getAddress().getAddress();
				
			for (int i = 0; i < ListObject.listPersons.size(); i++) {
				if (fStationAdr == ListObject.listPersons.get(i).getLocation().getAddress()) {
					
					List<String> listPplNearFstation = new ArrayList<>();
					
					LastName =  ListObject.listPersons.get(i).getLastName();
					firstName = ListObject.listPersons.get(i).getFirstName(); 
					phone = ListObject.listPersons.get(i).getPhone();
					birthDate = ListObject.listBirthDate.get(i).getBirthDate().toString();
					address = ListObject.listPersons.get(i).getLocation().getAddress();
					city = ListObject.listPersons.get(i).getLocation().getCity();
					zip = ListObject.listPersons.get(i).getLocation().getZip();
					
					listPplNearFstation.add(firstName);
					listPplNearFstation.add(LastName);
					listPplNearFstation.add(birthDate);
					listPplNearFstation.add(address);
					listPplNearFstation.add(city);
					listPplNearFstation.add(zip);
					listPplNearFstation.add(phone);
		
					
					listPplNearFstationRtrn = listPplNearFstation;


				}
			}
			
			
		
						return  listPplNearFstationRtrn;
	}


	
	public List<MedicalRecords> displayAllMedicalRecords() {
		
		return ListObject.listMedicalRecords;

	}
}
