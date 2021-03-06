package com.safety.net;

import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.safety.net.services.DisplayInfo;
import com.sun.el.parser.ParseException;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@ComponentScan
@SpringBootApplication
public class SafetyNetApplication {
	
	
	@Autowired
	DisplayInfo displayApiAscii;
	
	
	public final static Logger LOG =  LogManager.getLogger(SafetyNetApplication.class.getName());

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		SpringApplication.run(SafetyNetApplication.class, args);
		
			
//        LOG.debug("This is a debug statement");
//        LOG.info("This is Info Log");
//        LOG.warn("This is Warn Log");
//        LOG.error("This is Error Log");
//        LOG.trace("This is trace Log");
//        LOG.fatal("This is Fatal Log");
		
		
	}
	

}
