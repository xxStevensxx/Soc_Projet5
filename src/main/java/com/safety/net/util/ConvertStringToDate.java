package com.safety.net.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class ConvertStringToDate {
	
	
	public Date convertStringToDate(String sDate) throws ParseException{
		
		Date date = new SimpleDateFormat("MM/dd/yyyy").parse(sDate);
		
				return date;
	}

}
