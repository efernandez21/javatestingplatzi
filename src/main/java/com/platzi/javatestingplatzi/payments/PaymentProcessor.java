package com.platzi.javatestingplatzi.payments;

import static com.platzi.javatestingplatzi.payments.PaymentResponse.PaymentStatus.OK;

public class PaymentProcessor {

    private PaymentGateway paymentGateway;

    public PaymentProcessor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    /**
     * Metodo de comprobacion de pago correcto o no
     * @param amount la cantidad a pagar
     * @return proceso de pago correcto true o false
     */
    public boolean makePayment(double amount) {
        PaymentResponse response = paymentGateway.requestPayment(new PaymentRequest(amount));
        return response.getStatus() == OK;
    }
}
