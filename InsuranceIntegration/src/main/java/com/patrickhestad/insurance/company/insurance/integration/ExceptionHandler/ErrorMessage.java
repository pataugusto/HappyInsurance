package com.patrickhestad.insurance.company.insurance.integration.ExceptionHandler;

public class ErrorMessage {

	private String error;

	public ErrorMessage(String error) {
		this.error = error;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}