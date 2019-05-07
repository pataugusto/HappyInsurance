package com.patrickhestad.insurance.company.insurance.integration.validator.validators;

import com.patrickhestad.insurance.company.insurance.integration.validator.NationalIdConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NationalIdValidator implements ConstraintValidator<NationalIdConstraint, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {


		if(value != null && value.matches("[0-9]{11}")) {
			return true;
		}

		context.disableDefaultConstraintViolation();
		context
				.buildConstraintViolationWithTemplate("National id must be exactly 11 digits. Input was: " + value)
				.addConstraintViolation();

		return false;
	}

	@Override
	public void initialize(NationalIdConstraint constraintAnnotation) {
	}
}
