package com.finleap.weatherforecast.dao.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Main {
	
	@JsonProperty("temp")
    private Float temp;
	
    @JsonProperty("temp_min")
    private Float tempMin;
    
	@JsonProperty("temp_max")
	private Float tempMax;
	
	@JsonProperty("pressure")
	private Float pressure;
	
	@JsonProperty("sea_level")
	private Float seaLevel;
	
	@JsonProperty("grnd_level")
	private Float grndLevel;
	
	@JsonProperty("humidity")
	private Integer humidity;
	
	@JsonProperty("temp_kf")
	private Integer tempKF;
	
	public Float getTemp() {
		return temp;
	}
	public void setTemp(Float temp) {
		this.temp = temp;
	}
	public Float getTempMin() {
		return tempMin;
	}
	public void setTempMin(Float tempMin) {
		this.tempMin = tempMin;
	}
	public Float getTempMax() {
		return tempMax;
	}
	public void setTempMax(Float tempMax) {
		this.tempMax = tempMax;
	}
	public Float getPressure() {
		return pressure;
	}
	public void setPressure(Float pressure) {
		this.pressure = pressure;
	}
	public Float getSeaLevel() {
		return seaLevel;
	}
	public void setSeaLevel(Float seaLevel) {
		this.seaLevel = seaLevel;
	}
	public Float getGrndLevel() {
		return grndLevel;
	}
	public void setGrndLevel(Float grndLevel) {
		this.grndLevel = grndLevel;
	}
	public Integer getHumidity() {
		return humidity;
	}
	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}
	public Integer getTempKF() {
		return tempKF;
	}
	public void setTempKF(Integer tempKF) {
		this.tempKF = tempKF;
	}

}
