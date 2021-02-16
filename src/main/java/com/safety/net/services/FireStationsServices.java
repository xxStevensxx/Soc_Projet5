package com.safety.net.services;

import org.springframework.stereotype.Component;

import com.safety.net.model.FireStations;
import com.safety.net.model.ListObject;

@Component
public class FireStationsServices {
	
		
	public boolean addFireStations(FireStations fireStation) {

		return ListObject.listFireStations.add(fireStation);

	}

}
