package com.finleap.weatherforecast.bizo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.finleap.weatherforecast.exception.InvalidCityException;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityServicesBOTest {
	
	@Autowired
	private CityServicesBO cityServicesBO;
	
	@Test(expected= InvalidCityException.class)
	public void testInvalidCity() throws InvalidCityException {
		cityServicesBO.obtainIdbyCityName("AEHIUHEIUAEHIUAHES");
	}
	
	public void testValidCity() throws InvalidCityException {
		long id = cityServicesBO.obtainIdbyCityName("Novinki");
		assertEquals(id, 519188);
	}

}
