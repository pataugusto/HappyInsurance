package com.patrickhestad.project.insurancecompany.repository;

import com.patrickhestad.project.insurancecompany.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryIT {

	@Autowired
	private CustomerRepository customerRepository;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void findByNationalId() {
		String nationalId = "080889";
		Optional<Customer> customer = customerRepository.findByNationalId(nationalId);
		assertThat(customer.get().getNationalId(), is(nationalId));
	}
}