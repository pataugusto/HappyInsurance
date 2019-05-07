package com.patrickhestad.project.insurancecompany.service.implementation;

import com.patrickhestad.project.insurancecompany.ExceptionHandler.CreationException;
import com.patrickhestad.project.insurancecompany.lib.StringUtils;
import com.patrickhestad.project.insurancecompany.lib.Validator;
import com.patrickhestad.project.insurancecompany.model.Customer;
import com.patrickhestad.project.insurancecompany.repository.CustomerRepository;
import com.patrickhestad.project.insurancecompany.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

	private static Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
	private final CustomerRepository customerRepository;
	private StringUtils stringUtils;
	private Validator validator;

	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
		this.stringUtils = new StringUtils();
		this.validator = new Validator();
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}


	@Override
	public Customer findCustomerById(Long id) {
		return customerRepository.findCustomerById(id);
	}

	@Override
	public Customer createCustomer(Customer customer) throws CreationException {
		// Invalid input
		boolean notNull = validator.notNull(customer.getFirstname(), customer.getLastname(), customer.getNationalId());
		if(!notNull) {
			log.error("Customer is missing parameter(s)");
			throw new CreationException("Customer is missing parameter(s)");
		}

		// Customer already existing
		if(isExistingCustomer(customer.getNationalId())) {
			log.error("Could not create new customer because customer with same national id already exist in database");
			throw new CreationException("Could not create new customer because customer with same national id already exist in database");
		}

		customerRepository.save(customer);
		return customer;
	}


	private boolean isExistingCustomer(String nationalId) {
		Optional<Customer> customerOptional = customerRepository.findByNationalId(nationalId);
		return customerOptional.isPresent();
	}
}
