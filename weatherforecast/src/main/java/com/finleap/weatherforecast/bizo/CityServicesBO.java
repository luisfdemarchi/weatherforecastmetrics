package com.finleap.weatherforecast.bizo;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finleap.weatherforecast.exception.InvalidCityException;
import com.finleap.weatherforecast.model.CityData;

@Service
public class CityServicesBO {
	
	private final Logger logger = LoggerFactory.getLogger(CityServicesBO.class);

	public long obtainIdbyCityName(String cityName) throws InvalidCityException{
		List<CityData> cities= obtainCitiesFromJsonFile();
		if(cities != null){
			for(CityData element:cities){
				if(element.getName().trim().equalsIgnoreCase(cityName)){
					return element.getId();
				}
			}
		}
		throw new InvalidCityException("Invalid city received: " + cityName);
	}

	private List<CityData> obtainCitiesFromJsonFile(){
		try {
			File file = new File("src/main/resources/city.list.json");
			String jsonString = FileUtils.readFileToString(file);
			List<CityData> cities = new ObjectMapper().readValue(jsonString, new TypeReference<List<CityData>>(){});
			return cities;
		} catch (Exception e) {
			logger.error("Error on obtaining city data from json file: " + e);
		}
		return null;
	}

}
