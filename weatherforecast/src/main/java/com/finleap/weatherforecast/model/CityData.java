package com.finleap.weatherforecast.model;

public class CityData {

	private Long id;
	private String name;
	private String country;
	private Coord coord;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public Coord getCoord() {
		return coord;
	}
	public void setCord(Coord coord) {
		this.coord = coord;
	}

	public static class Coord{
		private Float lon;
		private Float lat;
		public Float getLon() {
			return lon;
		}
		public void setLon(Float lon) {
			this.lon = lon;
		}
		public Float getLat() {
			return lat;
		}
		public void setLat(Float lat) {
			this.lat = lat;
		}
		
	}
	
}
