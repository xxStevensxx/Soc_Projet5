package com.safety.net.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.safety.net.model.Address;
import com.safety.net.model.FireStations;
import com.safety.net.model.ListObject;
import com.safety.net.util.CentralizedMsg;
import com.safety.net.util.FilterJcksn;

@Component
public class FireStationsServices {
	
	
	@Autowired
	FilterJcksn filterJcksn;
	
	@Autowired
	CentralizedMsg msg;
	
	Address adr = new Address();
		
		
	public boolean addFireStations(FireStations fireStation) {

		return ListObject.listFireStations.add(fireStation);

	}
	
	
	public List<FireStations> updateFireStation(FireStations fireStation, int iterator){
	
			
			if (fireStation.getAddress() != null || fireStation.getAddress().toString() != "") {
				
				ListObject.listFireStations.get(iterator).setStation(fireStation.getStation());
				ListObject.listFireStations.get(iterator).setAddress(fireStation.getAddress());
				
			}
				


		return ListObject.listFireStations;
		
	}
	
	
	
	public FireStations removeFireStation(int iterator) {
		
		return	ListObject.listFireStations.remove(iterator);

}
	

}
