package com.safety.net.services;


import java.io.FileNotFoundException;
import java.io.FileReader;
import org.springframework.stereotype.Component;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;



@Component
public class DataReader {
	

/* the directory where we can find the json file.
 * 
 * pathfile src: "src/main/resources/data.json" 
 * 
 * 
 * */
	
	public JsonObject readFile(String pathFile){
		
		JsonObject jsonFile = null ;
		
		try {
			jsonFile = (JsonObject) JsonParser.parseReader(new FileReader(pathFile));
			
		} catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
			e.printStackTrace();
		} 
				
			return  jsonFile;
	}
	

}
