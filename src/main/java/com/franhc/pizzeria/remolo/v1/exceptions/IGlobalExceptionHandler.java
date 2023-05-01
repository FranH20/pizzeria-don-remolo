package com.franhc.pizzeria.remolo.v1.exceptions;

import com.franhc.pizzeria.remolo.v1.payloads.dtos.MessageError;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public interface IGlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageError> handleValidationErrors(MethodArgumentNotValidException ex);

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<MessageError> handleValidationErrors(ConstraintViolationException ex);
}
