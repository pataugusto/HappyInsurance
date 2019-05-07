package com.patrickhestad.insurance.company.insurance.integration.service;

import com.patrickhestad.insurance.company.insurance.integration.model.ApplicationRequest;
import org.springframework.stereotype.Service;

@Service
public interface InsuranceService {

	ApplicationRequest createCustomerInsurance(ApplicationRequest applicationRequest);
	ApplicationRequest updateCustomerInsurance(ApplicationRequest applicationRequest);
}
