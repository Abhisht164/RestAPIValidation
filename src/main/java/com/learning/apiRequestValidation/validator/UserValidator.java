package com.learning.apiRequestValidation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class UserValidator implements ConstraintValidator<ValidateUserType,String> {
    @Override
    public boolean isValid(String employeeType, ConstraintValidatorContext constraintValidatorContext) {
        List<String> employeeTypes = Arrays.asList("Permanent", "Vendor");
        return employeeTypes.contains(employeeType);
    }
}
