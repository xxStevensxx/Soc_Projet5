package com.safety.net.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

@Component
public class ConvertStringToDate {
	
	
	public LocalDate convertStringToDate(String sDate) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/d/yyyy");
		
		LocalDate date  = LocalDate.parse(sDate, formatter);

			return date;
	}

}
