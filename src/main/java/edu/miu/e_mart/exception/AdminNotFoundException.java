package edu.miu.e_mart.exception;

public class AdminNotFoundException extends RuntimeException {

	private String message;

	public AdminNotFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
