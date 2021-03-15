package com.safety.net.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.google.gson.JsonArray;

@Component
public class Convertor {
	
	
	
	public LocalDate convertStringToDate(String sDate) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/d/yyyy");
		
		LocalDate date  = LocalDate.parse(sDate, formatter);

			return date;
	}
	
	
	public ArrayList<String> jsonToArrlistStr(JsonArray jsonArr) {

		ArrayList<String> arr = new ArrayList<String>();
		ArrayList<String> arrayToRtrn = null;
		boolean b = false;
	
		
		for (int i = 0; i < jsonArr.size(); i++) {
			b = true;
			String str = jsonArr.get(i).getAsString();
			arr.add(str);
			
			arrayToRtrn = arr;

		}
		
		
		if (b == false) {
			arr.add("None");
			arrayToRtrn = arr;
			
		}
		
		return arrayToRtrn;
	}


}
