package com.safety.net.model;

import java.util.ArrayList;

public class MedicalRecords {

	private ArrayList<String> medications;
	private ArrayList<String> allergies;


	
	public ArrayList<String> getMedications() {
		return medications;
	}

	public void setMedications(ArrayList<String> medic) {
		this.medications = medic;
	}

	public ArrayList<String> getAllergies() {
		return allergies;
	}

	public void setAllergies(ArrayList<String> arrayAllergies) {
		this.allergies = arrayAllergies;
	}

}
