package com.ps.user.service.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND.NOT_FOUND)
public class UserException extends  RuntimeException{
    public UserException(String message) {
        super(message);
    }
}
