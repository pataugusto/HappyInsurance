package com.patrickhestad.insurance.company.insurance.integration.validator;


import com.patrickhestad.insurance.company.insurance.integration.validator.validators.NameValidator;
import com.patrickhestad.insurance.company.insurance.integration.validator.validators.NationalIdValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NationalIdValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NationalIdConstraint {
	String message() default "Invalid name";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}

