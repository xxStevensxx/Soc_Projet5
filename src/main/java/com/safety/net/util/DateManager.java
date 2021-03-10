package com.safety.net.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;


@Component
public class DateManager {
	
	
	public LocalDate convertDate(String sDate) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/d/yyyy");
		
		LocalDate date  = LocalDate.parse(sDate, formatter);

			return date;
	}
	
	
	
	public String calculateAge(String age){
		
		
		DateTimeFormatter formatterN = DateTimeFormatter.ofPattern("yyyy-MM-d");
		DateTimeFormatter formatterP = DateTimeFormatter.ofPattern("yyyy-MM-d");


		CharSequence currentDate = LocalDate.now().toString();
		LocalDate dateP  = LocalDate.parse(age, formatterP);
		LocalDate dateN = LocalDate.parse(currentDate,formatterN);
		
		String dateBtwn = Period.between(dateP, dateN).toString();
		
		Period parseAge = Period.parse(dateBtwn);
		
		String ageS = String.valueOf(parseAge.getYears());
		
		
				return ageS;
	
	
}
	
	
	public boolean underEighteenOrNot(String age) {
		
		
		boolean result;
		
		if (Integer.parseInt(age) <= 18) {

			result = true;
			
		} else {
			
			result = false;

		}
		
			return result;
		
	}
	
	
	public LocalDate convertStringToDate(String sDate) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/d/yyyy");
		
		LocalDate date  = LocalDate.parse(sDate, formatter);

			return date;
	}
	
	
//	
//	public int checkDatNotNull(LocalDate birthDate) {
//		
//		int ageRtrn = 0;
//		
//		if (birthDate != null) {
//			
//			LocalDate date = birthDate;
//			String age = calculateAge(date.toString());
//			
//			 ageRtrn = Integer.parseInt(age);
//			
//		}
//		
//		return ageRtrn;
//		
//	}
}
