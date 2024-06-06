package com.RESTFUL.Endpoints.controller;

import com.RESTFUL.Endpoints.model.NoMoneyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.ResponseEntity;

import com.RESTFUL.Endpoints.model.ErrorDetails;

@RestControllerAdvice   //  Tells spring that this a rest controller that gives advice
public class NmeControllerAdvice {

    @ExceptionHandler ( NoMoneyException.class )    //  annotation fulfills the try / catch responsibility
    public ResponseEntity <ErrorDetails> exceptionHandler () {
        ErrorDetails errorDetails = new ErrorDetails ();
        errorDetails.setMessage( "Insufficient Funds" );

        return ResponseEntity
                .badRequest()
                .body( errorDetails );
    }
}
