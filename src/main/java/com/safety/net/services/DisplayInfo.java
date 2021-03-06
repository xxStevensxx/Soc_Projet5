package com.safety.net.services;

import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.safety.net.model.FireStations;
import com.safety.net.model.ListObject;

import com.safety.net.model.Persons;
import com.safety.net.util.DateManager;
import com.safety.net.util.FilterJcksn;

@Service
public class DisplayInfo {

	Gson gson = new Gson();

	@Autowired
	DateManager dateManager;

	@Autowired
	FilterJcksn filterJcksn;

	public Map<JsonObject, ArrayList<Persons>> displayPplNearStationBis(int id) {

		Map<JsonObject, ArrayList<Persons>> listPplNearFstation = new HashMap<>();

		ArrayList<Persons> listPpl = new ArrayList<>();
		JsonObject listAdutltsAndChild = new JsonObject();
		ArrayList<Object> adultAndChild = new ArrayList<>();

		String fStationAdr = null;

		int child = 0;
		int adult = 0;

		for (int i = 0; i < ListObject.listFireStations.size(); i++) {

			boolean next = false;
			int fStationNb = ListObject.listFireStations.get(i).getStation();

			if (id == fStationNb) {

				next = true;
				fStationAdr = ListObject.listFireStations.get(i).getAddress().getAddress().toLowerCase()
						.replaceAll("//s", "");

			}

			if (next == true) {

				for (int iterator = 0; iterator < ListObject.listPersons.size(); iterator++) {

					if (fStationAdr.contains(ListObject.listPersons.get(iterator).getLocation().getAddress()
							.toLowerCase().replaceAll("//s", ""))) {

						Persons pplNxtStation = new Persons();

						pplNxtStation = ListObject.listPersons.get(iterator);

						listPpl.add(pplNxtStation);

						if (pplNxtStation.getAge() <= 18) {

							child++;

						} else {

							adult++;
						}

					}
				}
			}

		}

		adultAndChild.add("adults: " + adult);
		adultAndChild.add("childs: " + child);
		listAdutltsAndChild.add("adultAndChild", JsonParser.parseString(gson.toJson(adultAndChild)).getAsJsonArray());
		listPplNearFstation.put(listAdutltsAndChild, listPpl);

		return listPplNearFstation;
	}

	public ArrayList<Persons> childAlert(String address) {

//		Ajouter les membres de la famille pour respecter la consignes

		Persons ppl = null;
		Persons pplFamilly;
		ArrayList<Persons> listPpl = new ArrayList<>();
		String age = null;

		for (int iterator = 0; iterator < ListObject.listPersons.size(); iterator++) {

			String adrPpl = ListObject.listPersons.get(iterator).getLocation().getAddress().replaceAll("\\s", "")
					.toLowerCase();

			boolean checkAge = false;

			if (address.replaceAll("\\s", "").toLowerCase().contains(adrPpl)) {

				age = String.valueOf(ListObject.listPersons.get(iterator).getAge());
				checkAge = dateManager.underEighteenOrNot(age);

			}

			if (checkAge == true) {

				ppl = new Persons();
				ppl = ListObject.listPersons.get(iterator);
				listPpl.add(ppl);
				
				for (int jterator = 0; jterator < ListObject.listPersons.size(); jterator++) {

					String ageFamilly = String.valueOf(ListObject.listPersons.get(jterator).getAge());
					boolean checkAgeFamilly = dateManager.underEighteenOrNot(ageFamilly);

					if (checkAgeFamilly == false
							&& ListObject.listPersons.get(jterator).getLastName().contains(ppl.getLastName())) {

						pplFamilly = new Persons();

						pplFamilly = ListObject.listPersons.get(jterator);
						listPpl.add(pplFamilly);

					}

				}
			}
			
		}



		return listPpl;
	}
	

	public ArrayList<Persons> phoneAlert(int fireStationNumber) {

		FireStations fireStAdr = null;
		ArrayList<Persons> listPersonsNumber = new ArrayList<>();
		Persons personsNumber;

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

					String personAdr = ListObject.listPersons.get(i).getLocation().getAddress().toLowerCase()
							.replaceAll("//s", "");

					if (next == true && personAdr
							.contains(fireStAdr.getAddress().getAddress().toLowerCase().replaceAll("//s", ""))) {

						personsNumber = new Persons();

						personsNumber = ListObject.listPersons.get(i);

						listPersonsNumber.add(personsNumber);

					}

				}
			}

		}

		return listPersonsNumber;
	}

	public Map<ArrayList<Integer>, ArrayList<Persons>> fireAdr(String address) {

		ArrayList<Persons> listHabitant = new ArrayList<>();
		ArrayList<Integer> listFireNb = new ArrayList<>();
		Map<ArrayList<Integer>, ArrayList<Persons>> result = new HashMap<>();

		Persons habitant;
		int fireSt;

		for (int iterator = 0; iterator < ListObject.listPersons.size(); iterator++) {

			String adrPpl = ListObject.listPersons.get(iterator).getLocation().getAddress().replaceAll("\\s", "")
					.toLowerCase();

			if (address.replaceAll("\\s", "").toLowerCase().contains(adrPpl)) {

				habitant = new Persons();

				habitant = ListObject.listPersons.get(iterator);

				listHabitant.add(habitant);

			}

		}

		for (int jterator = 0; jterator < ListObject.listFireStations.size(); jterator++) {

			if (address.replaceAll("\\s", "").toLowerCase().contains(ListObject.listFireStations.get(jterator)
					.getAddress().getAddress().replaceAll("\\s", "").toLowerCase())) {

				fireSt = ListObject.listFireStations.get(jterator).getStation();

				listFireNb.add(fireSt);

			}
		}

		result.put(listFireNb, listHabitant);
		return result;
	}

	public HashSet<Persons> flood(ArrayList<Integer> stations) {

		boolean next;
		ArrayList<String> fStationAdr = new ArrayList<>();

		Persons grpPplAdr = null;
		HashSet<Persons> listGrpPplAdr = new HashSet<>();

		for (int i = 0; i < stations.size(); i++) {

			next = false;
			for (int iterator = 0; iterator < ListObject.listFireStations.size(); iterator++) {

				if (stations.get(i) == ListObject.listFireStations.get(iterator).getStation()) {

					next = true;
					fStationAdr.add(ListObject.listFireStations.get(iterator).getAddress().getAddress().toLowerCase()
							.replaceAll("//s", ""));

				}
			}

			if (next == true) {

				for (int jterator = 0; jterator < ListObject.listPersons.size(); jterator++) {

					for (String fAdr : fStationAdr) {

						if (fAdr.contains(ListObject.listPersons.get(jterator).getLocation().getAddress().toLowerCase()
								.replaceAll("//s", ""))) {

							grpPplAdr = new Persons();
							
							grpPplAdr = ListObject.listPersons.get(jterator);
							listGrpPplAdr.add(grpPplAdr);

						}

					}

				}
			}

		}
		 
		return listGrpPplAdr;
	}

	public ArrayList<Persons> personInfo(String firstName, String lastName) {

		Persons habitant;
		ArrayList<Persons> listHabitant = new ArrayList<>();
		Persons familly;

		String frstName;
		String lstName;

		for (int iterator = 0; iterator < ListObject.listPersons.size(); iterator++) {

			frstName = ListObject.listPersons.get(iterator).getFirstName().toLowerCase().replaceAll("\\s", "");
			lstName = ListObject.listPersons.get(iterator).getLastName().toLowerCase().replaceAll("\\s", "");

			if (frstName.equalsIgnoreCase(firstName.toLowerCase().replaceAll("\\s", ""))
					&& lstName.equalsIgnoreCase(lastName.toLowerCase().replaceAll("\\s", ""))) {

				habitant = ListObject.listPersons.get(iterator);
				listHabitant.add(habitant);

			}

		}

		/*
		 * Second tour a partir de zero afin d'ajouter la famille le stream n'est pas la
		 * bonne solution, il injecte des éléments null
		 */
		for (int jterator = 0; jterator < ListObject.listPersons.size(); jterator++) {

			frstName = ListObject.listPersons.get(jterator).getFirstName().replaceAll("\\s", "").toLowerCase();
			lstName = ListObject.listPersons.get(jterator).getLastName().replaceAll("\\s", "").toLowerCase();

			if (lstName.contains(lastName.replaceAll("\\s", "").toLowerCase())
					&& !frstName.contains(firstName.replaceAll("\\s", "").toLowerCase())) {

				familly = ListObject.listPersons.get(jterator);

				listHabitant.add(familly);
			}

		}

		return listHabitant;
	}

	public ArrayList<Persons> communityEmail(String city) {

		Persons pplMail = null;
		ArrayList<Persons> pplMailList = new ArrayList<>();

		for (int iterator = 0; iterator < ListObject.listPersons.size(); iterator++) {

			String pplCity = ListObject.listPersons.get(iterator).getLocation().getCity().replaceAll("\\s", "");

			if (pplCity.equalsIgnoreCase(city.replaceAll("\\s", ""))) {

				pplMail = ListObject.listPersons.get(iterator);

				pplMailList.add(pplMail);

			}

		}

		return pplMailList;
	}

}