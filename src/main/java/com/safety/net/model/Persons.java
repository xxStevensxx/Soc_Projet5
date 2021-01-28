package com.safety.net.model;


public class Persons {
	
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private Address location;
	private MedicalRecords medicalRecord;
	private BirthDate birthDate;
	
	
	
	
	public BirthDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(BirthDate birthDate) {
		this.birthDate = birthDate;
	}

	public MedicalRecords getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(MedicalRecords medicalRecord) {
		this.medicalRecord = medicalRecord;
	}
	
	public Address getLocation() {
		return location;
	}

	public void setLocation(Address location) {
		this.location = location;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {
		this.firstName = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	

}
