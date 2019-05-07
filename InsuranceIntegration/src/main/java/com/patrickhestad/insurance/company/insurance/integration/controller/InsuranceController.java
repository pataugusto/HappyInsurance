package com.patrickhestad.insurance.company.insurance.integration.controller;


import com.patrickhestad.insurance.company.insurance.integration.ExceptionHandler.CreationException;
import com.patrickhestad.insurance.company.insurance.integration.dto.CustomerCreatedDto;
import com.patrickhestad.insurance.company.insurance.integration.model.ApplicationRequest;
import com.patrickhestad.insurance.company.insurance.integration.service.InsuranceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Path("insurance")
public class InsuranceController {
	private static Logger log = LoggerFactory.getLogger(InsuranceController.class);

	private final InsuranceService insuranceService;

	@Autowired
	public InsuranceController(InsuranceService insuranceService) {
		this.insuranceService = insuranceService;
	}


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createInsurance(@Valid ApplicationRequest applicationRequest, @Context HttpHeaders headers) {
		log.info("Incomming request for insurance");
		log.info("Headers: " + headers.getRequestHeaders().toString());

		// Create Customer and insurance
		log.info("Creating customer and insurance");
		try {
			applicationRequest = insuranceService.createCustomerInsurance(applicationRequest);
		} catch(CreationException e) {
			throw new CreationException(e.getMessage());
		}

		// Send mail to customer
		log.info("\'Sending mail to customer\'");

		// Update customer insurance status
		log.info("Updating customer insurance status");
		applicationRequest = insuranceService.updateCustomerInsurance(applicationRequest);

		return Response
				.status(Response.Status.CREATED)
				.entity(new CustomerCreatedDto(
						applicationRequest.getCustomerId(),
						applicationRequest.getInsuranceStatus()))
				.build();

	}
}
