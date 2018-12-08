package com.finleap.weatherforecast.dao.data;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.CalendarDeserializer;
import com.fasterxml.jackson.databind.ser.std.CalendarSerializer;

public class OpenWeatherMapResultElement {
	
	@JsonProperty("dt")
	private Long dt;
	
	@JsonProperty("main")
	private Main main;
	
	@JsonProperty("dt_txt")
	@JsonDeserialize(using = CalendarDeserializer.class)
	@JsonSerialize(using = CalendarSerializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Calendar date;
	
	public Long getDt() {
		return dt;
	}
	public void setDt(Long dt) {
		this.dt = dt;
	}
	public Main getMain() {
		return main;
	}
	public void setMain(Main main) {
		this.main = main;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}

}
