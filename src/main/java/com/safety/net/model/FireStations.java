package com.safety.net.model;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("filterOnFireStations")
public class FireStations {
	
	public int station;
	public Address address;

	public void setStation(int station) {
		this.station = station;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getStation() {
		return station;
	}

	public Address getAddress() {
		return address;
	}

}
