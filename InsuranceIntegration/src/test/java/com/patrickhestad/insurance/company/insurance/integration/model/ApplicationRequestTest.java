package com.patrickhestad.insurance.company.insurance.integration.model;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class ApplicationRequestTest {

	private static Validator validator;

	@BeforeClass
	public static void setupValidatorInstance() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}
/*
	@Test
	public void testTooShortNationalId() {
		ApplicationRequest user = new ApplicationRequest("John", "Smith", "123");
		Set<ConstraintViolation<ApplicationRequest>> violations = validator.validate(user);

		assertThat(violations.size(), is(1));

	}

	@Test
	public void testBlankFirstName() {
		ApplicationRequest user = new ApplicationRequest("", "Smith", "01234567890");
		Set<ConstraintViolation<ApplicationRequest>> violations = validator.validate(user);

		assertThat(violations.size(), is(1));
	}

	@Test
	public void testValidApplication() {
		ApplicationRequest user = new ApplicationRequest("John", "Smith", "01234567890");
		Set<ConstraintViolation<ApplicationRequest>> violations = validator.validate(user);

		assertThat(violations.size(), is(0));
	}

	*/


}