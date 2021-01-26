package com.safety.net;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SafetyNetApplication {
	

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		SpringApplication.run(SafetyNetApplication.class, args);
		

	}

}
