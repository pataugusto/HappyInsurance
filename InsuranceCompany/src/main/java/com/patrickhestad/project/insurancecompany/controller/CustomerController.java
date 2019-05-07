package com.patrickhestad.project.insurancecompany.controller;


import com.patrickhestad.project.insurancecompany.ExceptionHandler.CreationException;
import com.patrickhestad.project.insurancecompany.model.Customer;
import com.patrickhestad.project.insurancecompany.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@Path("/customers")
public class CustomerController {

	private static Logger log = LoggerFactory.getLogger(InsuranceController.class);
	private final CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCustomer(Customer customer, @Context HttpHeaders headers) {
		log.info("Creating new customer");
		log.info(""+headers.getLength());
		log.info(headers.getMediaType().toString());
		log.info(headers.getRequestHeaders().toString());

		System.out.println(customer);

		Customer out;
		try {
			out = customerService.createCustomer(customer);
		} catch(CreationException e) {
			throw new CreationException(e.getMessage());
		}


		return Response
				.status(Response.Status.CREATED)
				.entity(out.getId())
				.build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> fetchAllUsers() {
		return customerService.findAll();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer fetchCustomerById(@PathParam("id") final Long id) {
		return customerService.findCustomerById(id);
	}



}
