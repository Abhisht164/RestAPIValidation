package com.learning.apiRequestValidation.advice;

import com.learning.apiRequestValidation.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApplicationExceptionHandler {

        // Handles validation errors
        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<List<String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
            List<String> errors = ex.getBindingResult()
                    .getFieldErrors()
                    .stream()
                    .map(error -> error.getField() + ": " + error.getDefaultMessage())
                    .collect(Collectors.toList());

            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

        // Handles custom UserNotFoundException
        @ExceptionHandler(UserNotFoundException.class)
        public ResponseEntity<Map<String,String>> handleUserNotFoundException(UserNotFoundException ex) {
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("error", ex.getMessage());
            return new ResponseEntity<>(errorMap,HttpStatus.NOT_FOUND);
        }
    }
