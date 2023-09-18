package com.app.testAuthSecurity.customException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ConfigAdviceContol {

    @ExceptionHandler
    public ResponseEntity<ErrorMessage> resouseAlreadyExiste(ResourceExistException e){
        ErrorMessage errorMessage=new ErrorMessage();
        errorMessage.setMessage(e.getMessage());
        errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorMessage.setTime(System.currentTimeMillis());
        return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);

    }


}
