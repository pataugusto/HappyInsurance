package com.patrickhestad.insurance.company.insurance.integration.validator;

import com.patrickhestad.insurance.company.insurance.integration.validator.validators.NameValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = NameValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NameConstraint {
	String message() default "Invalid name";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
