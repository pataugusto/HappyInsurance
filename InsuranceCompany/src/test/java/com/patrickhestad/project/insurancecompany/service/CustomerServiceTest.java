package com.patrickhestad.project.insurancecompany.service;

import com.patrickhestad.project.insurancecompany.repository.CustomerRepository;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class CustomerServiceTest {

	@Mock
	CustomerRepository customerRepository;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
}