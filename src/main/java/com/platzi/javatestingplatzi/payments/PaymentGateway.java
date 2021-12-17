package com.platzi.javatestingplatzi.payments;

public interface PaymentGateway {

    PaymentResponse requestPayment(PaymentRequest request);
}
