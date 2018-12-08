package com.finleap.weatherforecast.bizo;

import java.util.Calendar;
import java.util.TimeZone;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.finleap.weatherforecast.dao.data.OpenWeatherMapResult;
import com.finleap.weatherforecast.dao.data.OpenWeatherMapResultElement;
import com.finleap.weatherforecast.dao.ws.OpenWeatherMapDAO;
import com.finleap.weatherforecast.exception.InvalidCityException;
import com.finleap.weatherforecast.model.AverageWeatherForecastData;


/**
 * Business object responsible for capturing data about the weather for the next days and calculate the average temperature and pressure
 * @author Luis_Fernando_Amaral
 *
 */
@Service
public class WeatherForecastBO {
	
	private final Logger logger;
	private OpenWeatherMapDAO openWeatherMapDAO;
	private CityServicesBO cityServicesBO;
	private int numberOfDays;
	
	@Autowired
	public WeatherForecastBO(OpenWeatherMapDAO openWeatherMapDAO, CityServicesBO cityServicesBO,  @Value("${numberOfDays}") int numberOfDays){
		this.openWeatherMapDAO = openWeatherMapDAO;
		this.cityServicesBO = cityServicesBO;
		this.numberOfDays = numberOfDays;
		logger = LoggerFactory.getLogger(WeatherForecastBO.class);
	}

	public AverageWeatherForecastData obtainFiveDaysWeatherData(String cityName) throws InvalidCityException{
		long cityId = cityServicesBO.obtainIdbyCityName(cityName);
		return this.obtainFiveDaysWeatherData(cityId);
	}

	public AverageWeatherForecastData obtainFiveDaysWeatherData(Long cityId) {
		logger.debug("Obtaining weather metrics for city ID: " + cityId);
		OpenWeatherMapResult map = openWeatherMapDAO.obtainFiveDaysWeatherData(cityId);
		AverageWeatherForecastData  avgData = new AverageWeatherForecastData();
		if (map != null && map.getList() != null){
			avgData.setAvgPressure(map.getList().stream().filter(e -> isOnNext3Days(e))
					.collect(Collectors.averagingDouble((x) -> x.getMain().getPressure())));
			avgData.setAvgTempDay(map.getList().stream().filter(e -> isDayHour(e) && isOnNext3Days(e))
					.collect(Collectors.averagingDouble((x) -> x.getMain().getTemp())));
			avgData.setAvgTempNight(map.getList().stream().filter(e -> !isDayHour(e) && isOnNext3Days(e))
					.collect(Collectors.averagingDouble((x) -> x.getMain().getTemp())));	
		}
		return avgData;
	}


	private boolean isOnNext3Days(OpenWeatherMapResultElement e) {
		Calendar now = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		Calendar limitDate = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		limitDate.add(Calendar.DATE, numberOfDays);
		boolean result = e.getDate().after(now) && e.getDate().before(limitDate);
		return result;
	}


	private boolean isDayHour(OpenWeatherMapResultElement e) {
		 int hour = e.getDate().get(Calendar.HOUR_OF_DAY);
		 return hour > 6 && hour <= 18;
	}

}
