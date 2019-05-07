package com.patrickhestad.project.insurancecompany.ExceptionHandler;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;



public class CreationException extends RuntimeException {
	public CreationException(String message) {
		super(message);
	}
}


