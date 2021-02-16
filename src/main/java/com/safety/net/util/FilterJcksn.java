package com.safety.net.util;

import org.apache.catalina.mapper.Mapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.safety.net.model.Persons;

@Component
@Configuration 
public class FilterJcksn {
	
	public void jacksonConfiguration(ObjectMapper objectMapper) { 
		
	        objectMapper.setFilterProvider(new SimpleFilterProvider().setFailOnUnknownId(false)); 
	    
	}
	
	public MappingJacksonValue pplNearStationFilter(Persons view) {
		
		SimpleBeanPropertyFilter filterOn = SimpleBeanPropertyFilter.serializeAllExcept("medicalRecord");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("filterOnPersons", filterOn );
		MappingJacksonValue mapJcks = new MappingJacksonValue(view);
		
		mapJcks.setFilters(filterProvider);
					
			return mapJcks;
	}

}
