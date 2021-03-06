package com.safety.net.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.safety.net.model.Address;
import com.safety.net.model.FireStations;
import com.safety.net.model.ListObject;
import com.safety.net.model.MedicalRecords;
import com.safety.net.model.Persons;
import com.safety.net.util.CheckDuplicateValue;
import com.safety.net.util.Convertor;
import com.safety.net.util.DateManager;

@Service
public class ListConstruct {

	JsonObject jsonFile;
	
	List<Address> listAdr = ListObject.listAddress;
	List<Persons> listPers = ListObject.listPersons;
	List<FireStations> listFir = ListObject.listFireStations;
	List<MedicalRecords> listMed = ListObject.listMedicalRecords;

	@Autowired
	DataReader dtr;

	@Autowired
	CheckDuplicateValue checkDuplicateValue;

	@Autowired
	DateManager dateMngr;
	
	@Autowired
	Convertor convert;
	
	String adr;
	String city;
	String zip;

	boolean resultOfChkDuplicateVle = false;

	
	
	public void constructPerson() {
		
		JsonArray jsonArray = jsonFile.getAsJsonArray("persons");

		for (int iterator = 0; iterator < jsonArray.size(); iterator++) {

			JsonObject jsonObject = jsonArray.get(iterator).getAsJsonObject();

			Persons person = new Persons();
			Address address = checkDuplicateValue.checkAdr(jsonObject.get("address").getAsString());

			person.setFirstName(jsonObject.get("firstName").getAsString());
			person.setLastName(jsonObject.get("lastName").getAsString());
			person.setPhone(jsonObject.get("phone").getAsString());
			person.setEmail(jsonObject.get("email").getAsString());

			if (address == null) {

				address = new Address();

				address.setAddress(jsonObject.get("address").getAsString());
				address.setCity(jsonObject.get("city").getAsString());
				address.setZip(jsonObject.get("zip").getAsString());

				person.setLocation(address);
				
				listAdr.add(address);

			} else {

				person.setLocation(address);

			}

			listPers.add(person);

		}

	}
	

	public void constructFireStations() {

		JsonArray jsonArray = jsonFile.getAsJsonArray("firestations");

		Address address;

		for (int iterator = 0; iterator < jsonArray.size(); iterator++) {
			JsonObject jsonObject = jsonArray.get(iterator).getAsJsonObject();

			FireStations firestation = new FireStations();

			address = listAdr.stream()
					.filter(predicate -> predicate.getAddress().equals(jsonObject.get("address").getAsString()))
					.findAny().orElse(null);

			firestation.setStation(jsonObject.get("station").getAsInt());
			firestation.setAddress(address);

			listFir.add(firestation);

		}

	}
	
	
	public void constructMedicalRecords(){

		JsonArray jsonArray = jsonFile.getAsJsonArray("medicalrecords");

		Persons person;
		MedicalRecords medicalRecord;
		LocalDate date;

		for (int iterator = 0; iterator < jsonArray.size(); iterator++) {
			JsonObject jsonObject = jsonArray.get(iterator).getAsJsonObject();


			String name = jsonObject.get("firstName").getAsString();
			String lastname = jsonObject.get("lastName").getAsString();

			person = checkDuplicateValue.checkPerson(name, lastname);
			

 			if (person.getFirstName() != null && person.getLastName() != null) {

				medicalRecord = new MedicalRecords();
				
				ArrayList<String> arrayMedic;
				ArrayList<String> arrayAllergies;

				
				arrayMedic = convert.jsonToArrlistStr(jsonObject.get("medications").getAsJsonArray());
				arrayAllergies = convert.jsonToArrlistStr(jsonObject.get("allergies").getAsJsonArray());

								
				medicalRecord.setMedications(arrayMedic);
				medicalRecord.setAllergies(arrayAllergies);
				
				date =  dateMngr.convertDate(jsonObject.get("birthdate").getAsString());


				person.setMedicalRecord(medicalRecord);
				person.setBirthDate(date);
				
				String age = dateMngr.calculateAge(date.toString());
				
				person.setAge(Integer.parseInt(age));

				listMed.add(medicalRecord);


			} else {
					
				constructPerson();
				/*
				 * Impossible qu'il soit null, du fait de la conception de l'app mais dans
				 * l'évantualité placer un try catch
				 */
	
			}

		}

	}

	
	@PostConstruct
	public void callAllConstruct(){
		jsonFile = dtr.readFile("src/main/resources/data.json");
		constructPerson();
		constructFireStations();
		constructMedicalRecords();
	}

}
