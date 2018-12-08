package com.finleap.weatherforecast.controller;

import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.finleap.weatherforecast.bizo.WeatherForecastBO;
import com.finleap.weatherforecast.exception.InvalidCityException;
import com.finleap.weatherforecast.model.AverageWeatherForecastData;

@RestController
@RequestMapping("/data")
public class WeatherForecastController {
	
	private final Logger logger;
	
	private final WeatherForecastBO weatherForecastBO;
	
	@Autowired
	public WeatherForecastController(WeatherForecastBO weatherForecastBO) {
		this.weatherForecastBO = weatherForecastBO;
		logger = LoggerFactory.getLogger(WeatherForecastController.class);
	}
	
	@RequestMapping(value = "/{city}",produces = "application/json")
	public @ResponseBody AverageWeatherForecastData getMetrics(@PathVariable("city") String city) throws InvalidCityException, URISyntaxException{
		logger.debug("Obtaining weather metrics for city: " + city);
		return weatherForecastBO.obtainFiveDaysWeatherData(city);
	}
}
