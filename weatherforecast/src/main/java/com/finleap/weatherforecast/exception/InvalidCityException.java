package com.finleap.weatherforecast.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "There requested city does not exist.")
public class InvalidCityException extends Exception {

	public InvalidCityException(String message) {
		super(message);
	}

}
