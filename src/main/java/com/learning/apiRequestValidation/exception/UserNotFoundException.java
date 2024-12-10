package com.learning.apiRequestValidation.exception;

import java.util.HashMap;
import java.util.Map;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
