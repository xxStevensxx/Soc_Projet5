package com.safety.net.services;

import java.text.ParseException;
import java.util.Date;

//import java.util.Collection;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.safety.net.model.Address;
import com.safety.net.model.BirthDate;
import com.safety.net.model.FireStations;
import com.safety.net.model.ListObject;
import com.safety.net.model.MedicalRecords;
import com.safety.net.model.Persons;
import com.safety.net.util.CheckDuplicateValue;
import com.safety.net.util.ConvertStringToDate;

@Service
public class ListConstruct {

	JsonObject jsonFile;

	@Autowired
	DataReader dtr;

	@Autowired
	CheckDuplicateValue checkDuplicateValue;

	@Autowired
	ConvertStringToDate cvrtStringToDate;

//	Address optionalValue = new Address();
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
//			person.setPhone(jsonObject.get("phone").getAsInt());
			person.setEmail(jsonObject.get("email").getAsString());

			if (address == null) {

				address = new Address();

				address.setAddress(jsonObject.get("address").getAsString());
				address.setCity(jsonObject.get("city").getAsString());
				address.setZip(jsonObject.get("zip").getAsString());

				person.setLocation(address);

				ListObject.listAddress.add(address);

			} else {

				person.setLocation(address);

			}

			ListObject.listPersons.add(person);

		}

	}
	
	

	public void constructFireStations() {

		JsonArray jsonArray = jsonFile.getAsJsonArray("firestations");

		Address address;

		for (int iterator = 0; iterator < jsonArray.size(); iterator++) {
			JsonObject jsonObject = jsonArray.get(iterator).getAsJsonObject();

			FireStations firestation = new FireStations();

			address = ListObject.listAddress.stream()
					.filter(predicate -> predicate.getAddress().equals(jsonObject.get("address").getAsString()))
					.findAny().orElse(null);

			firestation.setStation(jsonObject.get("station").getAsInt());
			firestation.setAddress(address);

			ListObject.listFireStations.add(firestation);

		}

	}
	
	

	public void constructMedicalRecords() throws ParseException {

		JsonArray jsonArray = jsonFile.getAsJsonArray("medicalrecords");

		Persons person;
		BirthDate birthDate;
		MedicalRecords medicalRecord;
		Date date;

		for (int iterator = 0; iterator < jsonArray.size(); iterator++) {
			JsonObject jsonObject = jsonArray.get(iterator).getAsJsonObject();


			String name = jsonObject.get("firstName").getAsString();
			String lastname = jsonObject.get("lastName").getAsString();

			person = checkDuplicateValue.checkPerson(name, lastname);

			if (person != null) {

				medicalRecord = new MedicalRecords();
				birthDate = new BirthDate();
				
				
//				medicalRecord.setAllergies(jsonObject.get("allergies").getAsJsonArray().getAsString());
//				medicalRecord.setMedications(jsonObject.get("medications").getAsJsonArray().getAsString());

				date = cvrtStringToDate.convertStringToDate(jsonObject.get("birthdate").getAsString());
				
				birthDate.setBirthDate(date);

				person.setMedicalRecord(medicalRecord);
				person.setBirthDate(birthDate);

				ListObject.listMedicalRecords.add(medicalRecord);
				ListObject.listBirthDate.add(birthDate);

			} else {

				/*
				 * Impossible qu'il soit null, du fait de la conception de l'app mais dans
				 * l'évantualité placer un try catch
				 */

			}

			ListObject.listPersons.add(person);
		}

	}

	@PostConstruct
	public void callAllConstruct() throws ParseException {
		jsonFile = dtr.readFile("src/main/resources/data.json");
		constructPerson();
		constructFireStations();
		constructMedicalRecords();
	}

}
