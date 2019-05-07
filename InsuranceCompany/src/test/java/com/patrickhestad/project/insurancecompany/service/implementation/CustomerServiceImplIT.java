package com.patrickhestad.project.insurancecompany.service.implementation;

import com.patrickhestad.project.insurancecompany.model.Customer;
import com.patrickhestad.project.insurancecompany.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerServiceImplIT {

	private CustomerServiceImpl customerService;

	@Mock
	private CustomerRepository customerRepository;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		customerService = new CustomerServiceImpl(customerRepository);
	}

/*
	@Test
	public void testFindByNationalId() {

		String nationalId = "08088928904";
		Customer customerData = new Customer();
		customerData.setNationalId(nationalId);

		when(customerService.findByNationalId(nationalId)).thenReturn(customerData);

		//Optional<Customer> customer = customerService.findByNationalId(nationalId);

		//assertThat(customer.getNationalId(), is(nationalId));

		verify(customerRepository, times(1)).findAll();
	}
	*/
}