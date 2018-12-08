package com.finleap.weatherforecast.dao.ws;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import com.finleap.weatherforecast.config.OpenWeatherMapProperties;
import com.finleap.weatherforecast.dao.data.OpenWeatherMapResult;

@Repository
public class OpenWeatherMapDAO {
	private OpenWeatherMapProperties openWeatherProperties;
	private RestTemplate restTemplate;
	
	@Autowired
	public OpenWeatherMapDAO(OpenWeatherMapProperties openWeatherMapProperties,
							RestTemplate restTemplate){
		this.openWeatherProperties = openWeatherMapProperties;
		this.restTemplate = restTemplate;
	}
	
	public OpenWeatherMapResult obtainFiveDaysWeatherData(long cityId) {
		URI uri = new UriTemplate("{baseUrl}?id={phoneNumber}&appid={key}&units=metric").expand(openWeatherProperties.getUrl(), cityId,openWeatherProperties.getKey());
		HttpHeaders httpHeaders = new HttpHeaders();
		HttpEntity<OpenWeatherMapResult> httpEntity = new HttpEntity<OpenWeatherMapResult>(httpHeaders);
		ResponseEntity<OpenWeatherMapResult> response = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, OpenWeatherMapResult.class);
		return response.getBody();
		
	}

}
