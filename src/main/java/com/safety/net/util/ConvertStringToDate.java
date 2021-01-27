package com.safety.net.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class ConvertStringToDate {
	
	
	public Date convertStringToDate(String sDate) {
		
		Date date = null;
		
		try {
			
			date = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
				return date;
	}

}
