package com.mehmetpekdemir.lion.shared;

import java.util.Date;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Getter
@Setter
public class ApiError {

	private int status;

	private String message;

	private String path;

	private long timestamp = new Date().getTime();

	private Map<String, String> validationErrors;

	public ApiError(int status, String message, String path) {
		this.status = status;
		this.message = message;
		this.path = path;
	}

}
