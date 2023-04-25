package com.franhc.pizzeria.remolo.v1.exceptions;

import com.franhc.pizzeria.remolo.v1.payloads.dto.MessageError;
import com.franhc.pizzeria.remolo.v1.util.FunctionUtils;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageError> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        MessageError messageError = new MessageError(HttpStatus.BAD_REQUEST.value(), "Invalid Parameters", errors);
        return new ResponseEntity<>(messageError, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<MessageError> handleValidationErrors(ConstraintViolationException ex) {
        List<String> errors = Collections.singletonList(FunctionUtils.filterMessageError(ex.getMessage(), ":"));
        MessageError messageError = new MessageError(HttpStatus.BAD_REQUEST.value(), "Invalid Parameters", errors);
        return new ResponseEntity<>(messageError, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}
