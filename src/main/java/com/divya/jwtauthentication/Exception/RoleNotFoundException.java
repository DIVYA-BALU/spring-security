package com.divya.jwtauthentication.Exception;

public class RoleNotFoundException extends RuntimeException{
    
    RoleNotFoundException(String message){
        super(message);
    }
}
