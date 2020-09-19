package com.mybank.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//If database query is not found in Db
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {
private static final long serialVersionUID = 1L;
public ResourceNotFoundException(String message){
    super(message);
}
}
