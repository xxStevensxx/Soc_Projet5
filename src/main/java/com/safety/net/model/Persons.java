package com.safety.net.model;



import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFilter;


@JsonFilter("filterOnPersons")
public class Persons {
	
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private Address location;
	private MedicalRecords medicalRecord;
	private LocalDate birthDate;
	private int age;
	
	
	
	
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
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
