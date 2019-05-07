package com.patrickhestad.project.insurancecompany.service.implementation;

import com.patrickhestad.project.insurancecompany.model.Insurance;
import com.patrickhestad.project.insurancecompany.model.Customer;
import com.patrickhestad.project.insurancecompany.repository.InsuranceRepository;
import com.patrickhestad.project.insurancecompany.repository.CustomerRepository;
import com.patrickhestad.project.insurancecompany.service.InsuranceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InsuranceServiceImpl implements InsuranceService {

	private static Logger log = LoggerFactory.getLogger(InsuranceServiceImpl.class);
	private final InsuranceRepository insuranceRepository;
	private final CustomerRepository customerRepository;

	@Autowired
	public InsuranceServiceImpl(InsuranceRepository insuranceRepository, CustomerRepository customerRepository) {
		this.insuranceRepository = insuranceRepository;
		this.customerRepository = customerRepository;
	}

	@Transactional
	@Override
	public Insurance createInsurance(Long customerId) {
		// First get customer
		Customer customer = findCustomerById(customerId);
		if(customer == null) {
			log.error("Could not find customer with customer id: " + customerId);
			return null;
		}

		// If true, customer already has insurance
		if(customer.getInsurance() != null) {
			return null;
		}

		log.info("Found customer");
		log.info("Creating insurance");

		// Create new insurance

		Insurance insurance = new Insurance("Inactive", customer);
		customer.setInsurance(insurance);
		customerRepository.save(customer);
		log.info("Saved insurance. Returning object");

		return insurance;
	}

	@Override
	public Customer findCustomerById(Long customerId) {
		return customerRepository.findCustomerById(customerId);
	}

	@Override
	public Insurance updateInsurance(Long id) {
		log.info("Looking for insurance id: " + id);
		Insurance insurance = insuranceRepository.findInsuranceById(id);

		log.info("Found insurance");
		System.out.println(insurance);

		log.info("Updating insurance status");
		insurance.setInsuranceStatus("Contract sent");
		log.info("Saving update");
		insuranceRepository.save(insurance);
		return insurance;
	}
}
