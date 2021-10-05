package com.griddynamics.gridu.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NoSuchEntityException extends ResponseStatusException {

    public NoSuchEntityException(String reason) {
        super(HttpStatus.NOT_FOUND, reason);
    }
}
