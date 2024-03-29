package com.divya.jwtauthentication.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = EmailAlreadyExistsException.class)
    public ResponseEntity<?> handleEmailAlreadyExistsException(){
        return new ResponseEntity<>("Email already exists",HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(value = RoleNotFoundException.class)
    public ResponseEntity<?> handleRoleNotFoundException(){
        return new ResponseEntity<>("Role not found",HttpStatus.BAD_REQUEST);
    }
}
