package com.divya.jwtauthentication.Exception;

public class EmailAlreadyExistsException extends RuntimeException{

    public EmailAlreadyExistsException(String msg){
        super(msg);
    }
    
}
