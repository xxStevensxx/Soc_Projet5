package com.safety.net.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.safety.net.model.FireStations;
import com.safety.net.model.ListObject;

import com.safety.net.model.Persons;
import com.safety.net.util.DateManager;

@Service
public class DisplayInfo {
	
	Gson gson = new Gson();

	@Autowired
	DateManager dateManager;

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
	String age;
	int child;
	int adult;
	ArrayList<String> allergies;
	ArrayList<String> medications;
	
	
	

	public JsonObject displayPplNearStation(int id) {

		JsonObject listPplNearFstation = null;
		List<Object> listPplNearFstationRtrn = new ArrayList<Object>();

		List<Object> listChild = new ArrayList<>();
		List<Object> listAdult = new ArrayList<>();

		JsonObject result = new JsonObject();

		String fStationAdr = ListObject.listFireStations.get(id).getAddress().getAddress();

		child = 0;
		adult = 0;

		for (int i = 0; i < ListObject.listPersons.size(); i++) {
			if (fStationAdr == ListObject.listPersons.get(i).getLocation().getAddress()) {

				listPplNearFstation = new JsonObject();

				LastName = ListObject.listPersons.get(i).getLastName();
				firstName = ListObject.listPersons.get(i).getFirstName();
				phone = ListObject.listPersons.get(i).getPhone();

				birthDate = ListObject.listBirthDate.get(i).getBirthDate().toString();
				age = dateManager.calculateAge(birthDate);

				if (Integer.parseInt(age) <= 18) {

					child++;
				} else {

					adult++;
				}

				address = ListObject.listPersons.get(i).getLocation().getAddress();
				city = ListObject.listPersons.get(i).getLocation().getCity();
				zip = ListObject.listPersons.get(i).getLocation().getZip();

				listPplNearFstation.addProperty("firstName", firstName);
				listPplNearFstation.addProperty("LastName", LastName);
				listPplNearFstation.addProperty("birthDate", birthDate);
				listPplNearFstation.addProperty("age", age);
				listPplNearFstation.addProperty("address", address);
				listPplNearFstation.addProperty("city", city);
				listPplNearFstation.addProperty("zip", zip);
				listPplNearFstation.addProperty("phone", phone);

				listPplNearFstationRtrn.add(listPplNearFstation);

			}

			result.add("Habitants", JsonParser.parseString(gson.toJson(listPplNearFstationRtrn)).getAsJsonArray());

		}

		listAdult.add("adult: " + String.valueOf(adult));
		listChild.add("child: " + String.valueOf(child));
		result.addProperty("adult", adult);
		result.addProperty("child", child);

		return result;
	}
	
	
	
	

	public JsonObject childAlert(String address) {

		List<Object> alert = new ArrayList<>();
		JsonObject result = new JsonObject();

		String age = null;

		for (int iterator = 0; iterator < ListObject.listPersons.size(); iterator++) {

			String adrPpl = ListObject.listPersons.get(iterator).getLocation().getAddress().replaceAll("\\s", "");
			boolean checkAge = false;

			if (address.replaceAll("\\s", "").contains(adrPpl)) {

				age = dateManager.calculateAge(ListObject.listBirthDate.get(iterator).getBirthDate().toString());
				checkAge = dateManager.underEighteenOrNot(age);

			}

			if (checkAge == true) {

				JsonObject list = new JsonObject();

				list.addProperty("firstName", ListObject.listPersons.get(iterator).getFirstName());
				list.addProperty("lastName", ListObject.listPersons.get(iterator).getLastName());
				list.addProperty("age", age);

				alert.add(list);
				result.add("underEighteen", JsonParser.parseString(gson.toJson(alert)).getAsJsonArray());

			}
		}

		return result;
	}
	
	
	
	

	public JsonObject phoneAlert(int fireStationNumber) {

		FireStations fireStAdr = null;
		JsonObject result = new JsonObject();
		List<String> personsNumber = new ArrayList<>();

		for (int iterator = 0; iterator < ListObject.listFireStations.size(); iterator++) {

			boolean next = false;
			int fireStationNb = ListObject.listFireStations.get(iterator).getStation();

			if (fireStationNb == fireStationNumber) {

				next = true;
				int fiInt = iterator;

				fireStAdr = ListObject.listFireStations.stream()
						.filter(predicate -> predicate.getAddress().getAddress()
								.contains(ListObject.listFireStations.get(fiInt).getAddress().getAddress()))
						.findAny().orElse(null);

			}

			if (next == true) {
				for (int i = 0; i < ListObject.listPersons.size(); i++) {

					String personAdr = ListObject.listPersons.get(i).getLocation().getAddress();

					if (next == true && personAdr.contains(fireStAdr.getAddress().getAddress())) {

						personsNumber.add(ListObject.listPersons.get(i).getPhone());

						result.add("phoneNumber", JsonParser.parseString(gson.toJson(personsNumber)).getAsJsonArray());
					}

				}
			}

		}

		return result;
	}
	
	
	
	
	
	public JsonObject fireAdr(String address) {
		
		List<Object> listHabitant = new ArrayList<>();
		List<Object> stationNb = new ArrayList<>();

		JsonObject result = new JsonObject();
		
		
		for (int iterator = 0; iterator < ListObject.listPersons.size(); iterator++) {
			
			String adrPpl = ListObject.listPersons.get(iterator).getLocation().getAddress().replaceAll("\\s", "");
			
			if (address.replaceAll("\\s", "").contains(adrPpl)) {
				
				JsonObject habitant = new JsonObject();
				
				
				habitant.addProperty("Nom", ListObject.listPersons.get(iterator).getLastName());
				habitant.addProperty("phoneNumber", ListObject.listPersons.get(iterator).getPhone());
				
				String age = dateManager.calculateAge(ListObject.listBirthDate.get(iterator).getBirthDate().toString());
				
				habitant.addProperty("age", age);
				
				habitant.addProperty("medications", ListObject.listPersons.get(iterator).getMedicalRecord().getMedications().toString());
				habitant.addProperty("allergies", ListObject.listPersons.get(iterator).getMedicalRecord().getAllergies().toString());
				
				listHabitant.add(habitant);

				
			}

		}
		
		for (int iteratorBis = 0; iteratorBis < ListObject.listFireStations.size(); iteratorBis++) {
			
			if (address.replaceAll("\\s", "").contains(ListObject.listFireStations.get(iteratorBis).getAddress().getAddress().replaceAll("\\s", ""))) {
				
				
				JsonObject StationNb = new JsonObject();
				String station = String.valueOf(ListObject.listFireStations.get(iteratorBis).getStation());
	
				StationNb.addProperty("number", station);
				
				stationNb.add(StationNb);
				
			}
		}
		
		result.add("Habitant", JsonParser.parseString(gson.toJson(listHabitant)).getAsJsonArray());
		result.add("FireStation", JsonParser.parseString(gson.toJson(stationNb)).getAsJsonArray());

		

				return result;
	}
	
	
	
	public JsonObject flood(List<Integer> stations) {
		
//		A faire !!

		return null;
	}
	
	
	
	
	public JsonObject personInfo(String firstName, String lastName) {
		
		JsonObject result = new JsonObject();
		
		JsonObject habitant;
		List<Object> listHab = new ArrayList<>();
		
		for (int iterator = 0; iterator < ListObject.listPersons.size(); iterator++) {
			
			String frstName = ListObject.listPersons.get(iterator).getFirstName().replaceAll("\\s", "");
			String lstName = ListObject.listPersons.get(iterator).getLastName().replaceAll("\\s", "");

			
			if(frstName.equalsIgnoreCase(firstName.replaceAll("\\s", "")) && lstName.equalsIgnoreCase(lastName.replace("\\s", ""))) {
				
				habitant = new JsonObject();
				
				habitant.addProperty("firstName", frstName);
				habitant.addProperty("lastName", lstName);
				
				String age = dateManager.calculateAge(ListObject.listBirthDate.get(iterator).getBirthDate().toString());
				
				habitant.addProperty("age", age);
				habitant.addProperty("mail", ListObject.listPersons.get(iterator).getEmail());
				habitant.addProperty("medications", ListObject.listMedicalRecords.get(iterator).getMedications().toString());
				habitant.addProperty("allergies", ListObject.listMedicalRecords.get(iterator).getAllergies().toString());
				
				listHab.add(habitant);
				
			}
			
			result.add("habitants", JsonParser.parseString(gson.toJson(listHab)).getAsJsonArray());
			
		}
		
		
		return result;
	}
	
	
	
	
	public JsonObject communityEmail(String city) {
		
		JsonObject mail;
		List<Object> listEmail = new ArrayList<>();
		
		JsonObject result = new JsonObject();
		
		
		for (int iterator = 0; iterator < ListObject.listPersons.size(); iterator++) {
			
			String pplCity = ListObject.listPersons.get(iterator).getLocation().getCity().replaceAll("\\s", "");
			
				if (pplCity.equalsIgnoreCase(city.replaceAll("\\s", ""))) {
					
					mail = new JsonObject();
					
					mail.addProperty("email", ListObject.listPersons.get(iterator).getEmail());
					
					listEmail.add(mail);
					
				}
				
				result.add("Emails", JsonParser.parseString(gson.toJson(listEmail)).getAsJsonArray());
		}
		
		return result;
	}
	
	
	
	

}
