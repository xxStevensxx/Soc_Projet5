package com.safety.net.services;

import org.springframework.stereotype.Component;

import com.safety.net.model.ListObject;
import com.safety.net.model.MedicalRecords;

@Component
public class MedicalRecordsServices {
	
	
	public boolean addMedicalRecords(MedicalRecords med) {

		return ListObject.listMedicalRecords.add(med);

	}


}
