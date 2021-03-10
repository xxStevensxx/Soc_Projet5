package com.safety.net.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.safety.net.model.Address;
import com.safety.net.model.FireStations;
import com.safety.net.model.ListObject;
import com.safety.net.services.ServicesCRUD;
import com.safety.net.util.CentralizedMsg;
import com.safety.net.util.FilterJcksn;

@RestController
public class FireStationsController {


	@Autowired
	FilterJcksn filterJcksn;

	@Autowired
	CentralizedMsg msg;
	
	@Autowired
	ServicesCRUD crud;

	ArrayList<FireStations> fireStations;
	boolean existe;
	String fireAdr;
	Address adr;
	int stationList;

	@RequestMapping(value = "/firestationAPI", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<MappingJacksonValue> addFireStations(@RequestBody FireStations fireStation) {

		fireStations = new ArrayList<>();

		for (int iterator = 0; iterator < ListObject.listFireStations.size(); iterator++) {

			existe = false;

			fireStations.add(ListObject.listFireStations.get(iterator));

			if (fireStation.getAddress().getAddress() == null || fireStation.getAddress().getCity() == null
					|| fireStation.getAddress().getZip() == null) {

				return new ResponseEntity<MappingJacksonValue>(filterJcksn.filterMsg(msg.msgManager(6)),
						HttpStatus.BAD_REQUEST);

			} else {

				fireAdr = ListObject.listFireStations.get(iterator).getAddress().getAddress().toLowerCase()
						.replaceAll("//s", "");

			}

			if (fireStation.getStation() == fireStations.get(iterator).getStation()
					&& fireStation.getAddress().getAddress().toLowerCase().replaceAll("//s", "").contains(fireAdr)) {

				existe = true;

				return new ResponseEntity<MappingJacksonValue>(filterJcksn.filterMsg(msg.msgManager(4)),
						HttpStatus.CONFLICT);

			}

		}

		if (existe == false) {

			if (fireStation.getAddress() != null) {

				crud.addAddress(fireStation.getAddress());

			}

			crud.addFireStations(fireStation);
			crud.addAddress(fireStation.getAddress());

			fireStations.add(fireStation);

		}

		return new ResponseEntity<MappingJacksonValue>(filterJcksn.genericFilterFire(fireStations), HttpStatus.CREATED);

	}

	@ResponseBody
	@RequestMapping(value = "/AllFireStations", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<MappingJacksonValue> readAllFireStations() {

		return new ResponseEntity<MappingJacksonValue>(filterJcksn.genericFilterFire(ListObject.listFireStations),
				HttpStatus.FOUND);

	}

	@RequestMapping(value = "/firestationUpdate", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<MappingJacksonValue> updateFireStations(@RequestBody FireStations fireStation,
			@RequestParam(name = "station", required = true) int station,
			@RequestParam(name = "address", required = true) String address) {

		boolean adrIsNull;

		for (int iterator = 0; iterator < ListObject.listFireStations.size(); iterator++) {

			adrIsNull = false;

			fireStations = new ArrayList<>();
			fireStations.add(ListObject.listFireStations.get(iterator));

			fireAdr = ListObject.listFireStations.get(iterator).getAddress().getAddress().toLowerCase();
			stationList = ListObject.listFireStations.get(iterator).getStation();

			if (address == null || address.isEmpty()) {

				adrIsNull = true;

			}

			if (adrIsNull == false && station == stationList
					&& address.toLowerCase().replaceAll("//s", "").contains(fireAdr)) {

				crud.updateFireStation(fireStation, iterator);

				return new ResponseEntity<MappingJacksonValue>(
						filterJcksn.genericFilterFire(ListObject.listFireStations), HttpStatus.OK);

			}
		}

		return new ResponseEntity<MappingJacksonValue>(filterJcksn.filterMsg(msg.msgManager(5)), HttpStatus.NOT_FOUND);

	}

	@ResponseBody
	@RequestMapping(value = "/deleteFireStation", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<MappingJacksonValue> deletePersons(
			@RequestParam(name = "station", required = true) int station,
			@RequestParam(name = "address", required = true) String address) {

		for (int iterator = 0; iterator < ListObject.listPersons.size(); iterator++) {

			fireStations = new ArrayList<>();

			fireStations.add(ListObject.listFireStations.get(iterator));

			int stationIterator = ListObject.listFireStations.get(iterator).getStation();
			String adrIterator = ListObject.listFireStations.get(iterator).getAddress().getAddress().toLowerCase();

			if (stationIterator == station && adrIterator.contains(address.toLowerCase().replaceAll("\\s", ""))) {

				crud.removeFireStation(iterator);

				return new ResponseEntity<MappingJacksonValue>(filterJcksn.genericFilterFire(ListObject.listFireStations),
						HttpStatus.ACCEPTED);

			}

		}

		return new ResponseEntity<MappingJacksonValue>(filterJcksn.filterMsg(msg.msgManager(5)), HttpStatus.NOT_FOUND);

	}

}
