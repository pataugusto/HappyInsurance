package com.patrickhestad.insurance.company.insurance.integration.service.implementation;

import com.patrickhestad.insurance.company.insurance.integration.ExceptionHandler.CreationException;
import com.patrickhestad.insurance.company.insurance.integration.model.ApplicationRequest;
import com.patrickhestad.insurance.company.insurance.integration.service.InsuranceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static java.net.HttpURLConnection.HTTP_CREATED;

@Service
public class InsuranceServiceImpl implements InsuranceService {
	private static Logger log = LoggerFactory.getLogger(InsuranceServiceImpl.class);


	@Value("${property.insurance.api.path}")
	private String apiPath;

	@Value("${property.insurance.api.path.customers}")
	private String CUSTOMER_REST_URI;

	@Value("${property.insurance.api.path.insurance}")
	private String INSURANCE_REST_URI;

	@Override
	public ApplicationRequest createCustomerInsurance(ApplicationRequest applicationRequest) {
		// Create customer
		applicationRequest = createCustomer(applicationRequest);
		if(applicationRequest == null) {
			return null;
		}

		// Create insurance for customer
		applicationRequest = createInsurance(applicationRequest);

		return applicationRequest;
	}

	@Override
	public ApplicationRequest updateCustomerInsurance(ApplicationRequest applicationRequest) {
		log.info("Updating customer insurance");
		Response response = updateInsuranceStatus(applicationRequest.getInsuranceId());
		log.info("Response returned: "+response.getStatus());

		if(response.getStatus() != HTTP_CREATED) {
			log.error("Error while trying to update insurance information");
			return null;
		}

		String insuranceStatus = response.readEntity(String.class);
		log.info("Response returned insurance status: " + insuranceStatus);
		applicationRequest.setInsuranceStatus(insuranceStatus);
		log.info("Insurance successfully updated");
		return applicationRequest;

	}

	private Response updateInsuranceStatus(String insuranceId) {
		String restURI = INSURANCE_REST_URI + insuranceId;
		log.info("Making request to: " + restURI);
		Client client = ClientBuilder.newClient();
		return client
				.target(restURI)
				.request(MediaType.APPLICATION_JSON)
				.put(Entity.entity(insuranceId, MediaType.APPLICATION_JSON));
	}


	private ApplicationRequest createCustomer(ApplicationRequest applicationRequest) throws CreationException {
		log.info("Creating new customer");
		Response response = createNewCustomer(applicationRequest);
		log.info("Response returned: "+ response.getStatus());
		if(response.getStatus() != HTTP_CREATED) {
			log.error("Error while trying to create new user");
			String errorMessage = response.readEntity(String.class);
			log.error("Error: " + errorMessage);
			throw new CreationException(errorMessage);

		}

		String customerId = response.readEntity(String.class).trim();
		log.info("Response returned customer id: " + customerId);
		applicationRequest.setCustomerId(customerId);
		log.info("Customer successfully created");

		return applicationRequest;
	}

	private Response createNewCustomer(ApplicationRequest applicationRequest) {
		log.info("Making request to: " + CUSTOMER_REST_URI);
		Client client = ClientBuilder.newClient();
		return client
				.target(CUSTOMER_REST_URI)
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(applicationRequest, MediaType.APPLICATION_JSON));
	}


	private ApplicationRequest createInsurance(ApplicationRequest applicationRequest) {
		log.info("Creating insurance for customer");
		Response response = createNewInsurance(applicationRequest.getCustomerId());
		log.info("Response returned: "+response.getStatus());
		if(response.getStatus() != HTTP_CREATED) {
			log.error("Error while trying to create new insurance");
			return null;
		}

		String insuranceId = response.readEntity(String.class);
		log.info("Response returned insurance id: " + insuranceId);
		applicationRequest.setInsuranceId(insuranceId);
		log.info("Insurance successfully created");
		return applicationRequest;
	}


	private Response createNewInsurance(String customerId) {
		String restURI = INSURANCE_REST_URI + customerId;
		log.info("Making request to: " + restURI);
		Client client = ClientBuilder.newClient();
		return client
				.target(restURI)
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(customerId, MediaType.APPLICATION_JSON));
	}


}
