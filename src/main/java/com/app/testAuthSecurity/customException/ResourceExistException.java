package com.app.testAuthSecurity.customException;


public class ResourceExistException extends RuntimeException {
    public ResourceExistException(String msg){
        super(msg);
    }
}
