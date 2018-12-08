package com.finleap.weatherforecast.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AverageWeatherForecastData implements Serializable{
	private Double avgTempNight;
	private Double avgTempDay;
	private Double avgPressure;
	
	public Double getAvgTempNight() {
		return this.avgTempNight;
	}
	public void setAvgTempNight(Double avgTempNight) {
		this.avgTempNight = avgTempNight;
	}
	public Double getAvgTempDay() {
		return this.avgTempDay;
	}
	public void setAvgTempDay(Double avgTempDay) {
		this.avgTempDay = avgTempDay;
	}
	public Double getAvgPressure() {
		return this.avgPressure;
	}
	public void setAvgPressure(Double avgPressure) {
		this.avgPressure = avgPressure;
	}

}
