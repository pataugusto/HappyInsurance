package com.patrickhestad.insurance.company.insurance.integration.validator.validators;

import com.patrickhestad.insurance.company.insurance.integration.validator.NameConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<NameConstraint, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value != null && value.matches("[A-Za-z]+");
	}

	@Override
	public void initialize(NameConstraint constraintAnnotation) {

	}
}
