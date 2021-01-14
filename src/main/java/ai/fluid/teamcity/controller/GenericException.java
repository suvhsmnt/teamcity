package ai.fluid.teamcity.controller;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "stackTrace", "cause", "suppressed", "localizedMessage" })
public class GenericException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8572254467112884046L;

	private int httpCode;

	/**
	 * Error Code as per our system to track the Error
	 */
	private String errorCode;

	/*
	 * Proper user-friendly Error message
	 */
	private String message;

	public GenericException(int httpCode, String errorCode, String message) {
		super();
		this.httpCode = httpCode;
		this.errorCode = StringUtils.isEmpty(errorCode) ? "N/A." : errorCode;
		this.message = StringUtils.isEmpty(message) ? "N/A." : message;
	}

	public int getHttpCode() {
		return httpCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setHttpCode(int httpCode) {
		this.httpCode = httpCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "GenericException [httpCode=" + httpCode + ", errorCode=" + errorCode + ", message=" + message + "]";
	}

}
