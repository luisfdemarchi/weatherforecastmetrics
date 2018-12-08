package com.finleap.weatherforecast.dao.ws;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OpenWeatherMapDAOTest {

	@Autowired
	private OpenWeatherMapDAO openWeatherMapDAO;
	
	@Test
	public void test(){
		assertNotNull(openWeatherMapDAO.obtainFiveDaysWeatherData(707860));
	}
}
