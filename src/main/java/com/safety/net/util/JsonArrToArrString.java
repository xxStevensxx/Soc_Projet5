package com.safety.net.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.google.gson.JsonArray;

@Component
public class JsonArrToArrString {

	public ArrayList<String> arrlistStr(JsonArray jsonArr) {

		ArrayList<String> arr = new ArrayList<String>();
		ArrayList<String> arrayToRtrn = null;

		for (int i = 0; i < jsonArr.size(); i++) {

			String str = jsonArr.get(i).getAsString();
			arr.add(str);
			arrayToRtrn = arr;

		}
		
		return arrayToRtrn;
	}

}
