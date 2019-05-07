package com.patrickhestad.insurance.company.insurance.integration.ExceptionHandler;

public class CreationException extends RuntimeException {
	public CreationException(String message) {
		super(message);
	}
}