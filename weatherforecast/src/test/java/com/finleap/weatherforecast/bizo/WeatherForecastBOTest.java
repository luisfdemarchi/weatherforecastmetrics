package com.finleap.weatherforecast.bizo;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.finleap.weatherforecast.dao.data.Main;
import com.finleap.weatherforecast.dao.data.OpenWeatherMapResult;
import com.finleap.weatherforecast.dao.data.OpenWeatherMapResultElement;
import com.finleap.weatherforecast.dao.ws.OpenWeatherMapDAO;
import com.finleap.weatherforecast.model.AverageWeatherForecastData;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherForecastBOTest {
	
	@Autowired
	private WeatherForecastBO weatherForecastBO;
	
	@MockBean
	private OpenWeatherMapDAO openWeatherMapDAO;
	
	@Test
	public void test() {
		OpenWeatherMapResult map = new OpenWeatherMapResult();
		List<OpenWeatherMapResultElement> list = new ArrayList<OpenWeatherMapResultElement>();
		list.add(this.getWeatherElement(new Float(25), new Float(5), 1, 14));
		list.add(this.getWeatherElement(new Float(5), new Float(8), 1, 12));
		list.add(this.getWeatherElement(new Float(3), new Float(10), 2, 20));
		list.add(this.getWeatherElement(new Float(3), new Float(21), 20, 12));//Should be not considered in average since is 20 days from now
		map.setList(list);
		when(openWeatherMapDAO.obtainFiveDaysWeatherData(anyLong())).thenReturn(map);
		AverageWeatherForecastData response =weatherForecastBO.obtainFiveDaysWeatherData(anyLong());
		assertEquals(response.getAvgPressure(), new Double(11));
		assertEquals(response.getAvgTempDay(), new Double(6.5));
		assertEquals(response.getAvgTempNight(), new Double(10));
	}

	private OpenWeatherMapResultElement getWeatherElement(Float pressure, Float temp, int daysToAdd, int hour) {
		OpenWeatherMapResultElement element = new OpenWeatherMapResultElement();
		Calendar date = Calendar.getInstance();
		date.set(Calendar.HOUR_OF_DAY, hour);
		date.add(Calendar.DATE, daysToAdd);
		element.setDate(date);
		Main main = new Main();
		main.setTemp(temp);
		main.setPressure(pressure);
		element.setMain(main);
		return element;
	}

}
