package com.patrickhestad.project.insurancecompany.service;


import com.patrickhestad.project.insurancecompany.model.Insurance;
import com.patrickhestad.project.insurancecompany.model.Customer;
import org.springframework.stereotype.Service;

@Service
public interface InsuranceService {

	Insurance createInsurance(Long customerId);
	Customer findCustomerById(Long customerId);
	Insurance updateInsurance(Long id);


}
