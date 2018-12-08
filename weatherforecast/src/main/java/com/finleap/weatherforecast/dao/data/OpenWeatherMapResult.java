package com.finleap.weatherforecast.dao.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpenWeatherMapResult {
	
	@JsonProperty("cod")
	private String cod;
	
	@JsonProperty("message")
	private Float message;
	
	@JsonProperty("cnt")
	private Integer cnt;
	
	@JsonProperty("list")
	private List<OpenWeatherMapResultElement> list;

	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public Float getMessage() {
		return message;
	}
	public void setMessage(Float message) {
		this.message = message;
	}
	public Integer getCnt() {
		return cnt;
	}
	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}
	public List<OpenWeatherMapResultElement> getList() {
		return list;
	}
	public void setList(List<OpenWeatherMapResultElement> list) {
		this.list = list;
	}
	

}
