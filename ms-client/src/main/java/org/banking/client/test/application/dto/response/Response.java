package org.banking.client.test.application.dto.response;

import lombok.Builder;
import lombok.Getter;

/**
 * Vo for response api
 *
 * @author jmena
 * @version 1.0
 * @param <T> Type data response
 */
@Builder
@Getter
public class Response<T> {

    /**
     * Data to response
     */
    private T data;

    /**
     * Message to response
     */
    private String message;

    /**
     * Code to response
     */
    private Integer code;
}
