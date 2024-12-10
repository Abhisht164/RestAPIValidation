package com.learning.apiRequestValidation.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Documented
@Constraint(validatedBy = UserValidator.class)
public @interface ValidateUserType {
    public String message() default "Invalid userType";

    Class<?>[] groups() default {}; // Mandatory groups parameter

    Class<? extends Payload>[] payload() default {}; // Mandatory payload parameter

    // Custom parameters (if needed, e.g., allowed user types)
    String[] allowedTypes() default {}; // Exa
}
