package com.RESTFUL.Endpoints.service;

import org.springframework.stereotype.Service;

import com.RESTFUL.Endpoints.model.PaymentDetails;
import com.RESTFUL.Endpoints.model.NoMoneyException;

@Service
public class PaymentService {

    public PaymentDetails processPayment () {
        throw new NoMoneyException();
    }
}
