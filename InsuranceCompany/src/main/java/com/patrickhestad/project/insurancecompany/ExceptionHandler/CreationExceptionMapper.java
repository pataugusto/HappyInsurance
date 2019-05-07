package com.patrickhestad.project.insurancecompany.ExceptionHandler;


import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CreationExceptionMapper implements ExceptionMapper<CreationException> {

	@Override
	public Response toResponse(CreationException e) {
		return Response.status(Response.Status.BAD_REQUEST)
				.entity(new ErrorMessage(e.getMessage())
				).type(MediaType.APPLICATION_JSON).build();
	}
}