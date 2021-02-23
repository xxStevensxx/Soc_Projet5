package com.safety.net.util;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.context.annotation.Configuration;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.google.gson.JsonObject;
import com.safety.net.model.Persons;

@Component
@Configuration
public class FilterJcksn {

	public void jacksonConfiguration(ObjectMapper objectMapper) {

		objectMapper.setFilterProvider(new SimpleFilterProvider().setFailOnUnknownId(false));

	}
	
	
	public MappingJacksonValue pplNearStationFilter(Map<JsonObject, ArrayList<Persons>> map) {

		SimpleBeanPropertyFilter filterOn = SimpleBeanPropertyFilter.serializeAllExcept("email",
				"birthDate", "medicalRecord");

		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("filterOnPersons", filterOn);

		MappingJacksonValue mapJcks = new MappingJacksonValue(map);

		mapJcks.setFilters(filterProvider);

			
		return mapJcks;
	}
	
	
	public MappingJacksonValue phoneAlertFilter(ArrayList<Persons> obj) {

		SimpleBeanPropertyFilter filterOn = SimpleBeanPropertyFilter.serializeAllExcept("location", "email",
				"birthDate", "firstName", "lastName", "medicalRecord", "age");

		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("filterOnPersons", filterOn);

		MappingJacksonValue mapJcks = new MappingJacksonValue(obj);

		mapJcks.setFilters(filterProvider);

			
		return mapJcks;
	}
	
	
	public MappingJacksonValue childAlertFilter(ArrayList<Persons> obj) {

		SimpleBeanPropertyFilter filterOn = SimpleBeanPropertyFilter.serializeAllExcept("location", "email",
				"birthDate", "medicalRecord", "phone");

		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("filterOnPersons", filterOn);

		MappingJacksonValue mapJcks = new MappingJacksonValue(obj);

		mapJcks.setFilters(filterProvider);

			
		return mapJcks;
	}
	
	

	public MappingJacksonValue pplNearStationFilter(Persons view) {

		SimpleBeanPropertyFilter filterOn = SimpleBeanPropertyFilter.serializeAllExcept("medicalRecord");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("filterOnPersons", filterOn);
		MappingJacksonValue mapJcks = new MappingJacksonValue(view);

		mapJcks.setFilters(filterProvider);

		return mapJcks;
	}

	public MappingJacksonValue communityEmailFilter(ArrayList<Persons> obj) {

		SimpleBeanPropertyFilter filterOn = SimpleBeanPropertyFilter.serializeAllExcept("medicalRecord", "firstName",
				"lastName", "birthDate", "phone", "location", "age");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("filterOnPersons", filterOn);
		MappingJacksonValue mapJcks = new MappingJacksonValue(obj);

		mapJcks.setFilters(filterProvider);

		return mapJcks;
	}

	public MappingJacksonValue personInfoFilter(ArrayList<Persons> obj) {

		SimpleBeanPropertyFilter filterOn = SimpleBeanPropertyFilter.serializeAllExcept("location");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("filterOnPersons", filterOn);
		MappingJacksonValue mapJcks = new MappingJacksonValue(obj);

		mapJcks.setFilters(filterProvider);

		return mapJcks;
	}
	
	
	public MappingJacksonValue floodFilter(ArrayList<Persons> obj) {

		SimpleBeanPropertyFilter filterOn = SimpleBeanPropertyFilter.serializeAll();
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("filterOnPersons", filterOn);
		MappingJacksonValue mapJcks = new MappingJacksonValue(obj);

		mapJcks.setFilters(filterProvider);

		return mapJcks;
	}
	
	public MappingJacksonValue fireAdrFilter(Map<ArrayList<Integer>, ArrayList<Persons>> map) {

		SimpleBeanPropertyFilter filterOnF = SimpleBeanPropertyFilter.serializeAllExcept("address");
		SimpleBeanPropertyFilter filterOnP = SimpleBeanPropertyFilter.serializeAllExcept("location", "email", "birthDate");

		FilterProvider filterProviderP = new SimpleFilterProvider().addFilter("filterOnPersons", filterOnP);
		FilterProvider filterProviderF = new SimpleFilterProvider().addFilter("filterOnFireStations", filterOnF);

		MappingJacksonValue mapJcks = new MappingJacksonValue(map);

		mapJcks.setFilters(filterProviderF);
		mapJcks.setFilters(filterProviderP);

			
		return mapJcks;
	}

}
