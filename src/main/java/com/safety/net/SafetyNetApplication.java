package com.safety.net;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.safety.net.services.DisplayApiAscii;

@SpringBootApplication
@ComponentScan
public class SafetyNetApplication {

	@Autowired
	DisplayApiAscii displayApiAscii;

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		SpringApplication.run(SafetyNetApplication.class, args);

	}
	
	@PostConstruct
	public void asciiSysOut() {
		displayApiAscii.displayAscii();
	}

}
