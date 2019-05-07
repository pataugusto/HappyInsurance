package com.patrickhestad.project.insurancecompany.service;

import com.patrickhestad.project.insurancecompany.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CustomerService {

	Customer createCustomer(Customer customer);
	List<Customer> findAll();
	Customer findCustomerById(Long id);



}
