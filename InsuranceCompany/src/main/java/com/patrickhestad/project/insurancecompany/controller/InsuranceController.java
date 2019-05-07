package com.patrickhestad.project.insurancecompany.controller;

import com.patrickhestad.project.insurancecompany.model.Customer;
import com.patrickhestad.project.insurancecompany.model.Insurance;
import com.patrickhestad.project.insurancecompany.service.InsuranceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RestController
@Path("/insurance")
public class InsuranceController {

	private static Logger log = LoggerFactory.getLogger(InsuranceController.class);

	private final InsuranceService insuranceService;

	@Autowired
	public InsuranceController(InsuranceService insuranceService) {
		this.insuranceService = insuranceService;
	}


	@POST
	@Path("/user/{id}")
	//@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createInsurance(@PathParam("id") String id, @Context HttpHeaders headers) {
		log.info("Input id: " + id);
		log.info(""+headers.getLength());
		log.info(headers.getMediaType().toString());

		log.info(headers.getRequestHeaders().toString());

		Insurance insurance = insuranceService.createInsurance(Long.parseLong(id));

		return Response
				.status(Response.Status.CREATED)
				.entity(insurance.getId())
				//.entity(insurance)
				.build();

	}


	@PUT
	@Path("/user/{id}")
	//@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateInsurance(@PathParam("id") Long id, @Context HttpHeaders headers) {
		log.info("Updating insurance");

		System.out.println(headers.getMediaType().toString());


		System.out.println(headers.getRequestHeaders().toString());
		System.out.println();

		Insurance insurance = insuranceService.updateInsurance(id);

		return Response
				.status(Response.Status.CREATED)
				.entity(insurance.getInsuranceStatus())
				.build();

		//return null;
		//return Response.ok(customerService.createCustomer()).build();
	}
}
