package org.banking.client.test.infraestructure.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class NotFoundException extends RuntimeException {

    private final HttpStatus httpStatus;
    private String internalMessage;

    public NotFoundException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public NotFoundException(String message, final String internalMessage, HttpStatus httpStatus) {
        super(message);
        this.internalMessage = internalMessage;
        this.httpStatus = httpStatus;
    }

    public NotFoundException(String message, HttpStatus httpStatus, Exception innerException) {
        super(message, innerException);
        this.httpStatus = httpStatus;
    }

    public NotFoundException(String message) {
        super(message);
        this.httpStatus = HttpStatus.NOT_FOUND;
    }

    public NotFoundException(String message, final String internalMessage) {
        super(message);
        this.internalMessage = internalMessage;
        this.httpStatus = HttpStatus.NOT_FOUND;
    }

}
