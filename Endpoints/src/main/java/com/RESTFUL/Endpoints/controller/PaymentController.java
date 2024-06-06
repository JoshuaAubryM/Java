package com.RESTFUL.Endpoints.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.logging.Logger;

import com.RESTFUL.Endpoints.model.PaymentDetails;
import com.RESTFUL.Endpoints.service.PaymentService;

@RestController
public class PaymentController {

    private final Logger logger = Logger.getLogger( PaymentController.class.getName() );

    private final PaymentService paymentService;
    //  payment service is a dependency of the controller

    //  constructor injection, no annotation required because there is only one constructor
    public PaymentController ( PaymentService paymentService ) {
        this.paymentService = paymentService;
    }

    //  this is an endpoint. It will not return a view
//    @PostMapping ( "/payment" )
//    public ResponseEntity < ? > postPayment () {
//        //  This method will throw an error through the dependency ( 404 error )
//        PaymentDetails paymentDetails = paymentService.processPayment ();
//
//        return ResponseEntity
//                .status (HttpStatus.ACCEPTED )
//                .body ( paymentDetails );
//    }

    @PostMapping ( "/payment" )
    public ResponseEntity < PaymentDetails > postPayment ( @RequestBody PaymentDetails paymentDetails ) {
        //  This method allows the user to set the amount manually.

        logger.info ( "Payment Accepted " + paymentDetails.getAmount() );
                return ResponseEntity
                        .status ( HttpStatus.ACCEPTED )
                        .body ( paymentDetails );
    }
}
