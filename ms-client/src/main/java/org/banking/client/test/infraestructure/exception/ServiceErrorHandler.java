package org.banking.client.test.infraestructure.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@ComponentScan(basePackages = "org.banking.client.test")
@Slf4j
public class ServiceErrorHandler {

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<Object> handleFilesNotFoundException(NotFoundException ex, WebRequest request) {
        var internalMessage = ex.getInternalMessage();
        ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getHttpStatus().toString(), ex.getMessage());
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), ex.getHttpStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<?> handleBindException(BindException bindException) {

        Map<String, String> errorMap = new HashMap<>();

        bindException.getAllErrors().
                forEach(objectError -> {
                    errorMap.put(
                            ((FieldError) objectError).getField(),
                            objectError.getDefaultMessage());
                });

        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleException(Exception ex, WebRequest request) {
        log.error("Error ExceptionHandler.: {}", ex);
        log.error("Error ExceptionHandler stackTrace.: {}", ex.getStackTrace());
        var message = "Error.: Por favor, contactarse con el Administrador del Sistema";
        ErrorMessage errorMessage = new ErrorMessage(new Date(),HttpStatus.INTERNAL_SERVER_ERROR.toString(), message);
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

