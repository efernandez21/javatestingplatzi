package com.platzi.javatestingplatzi.payments;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PaymentProcessorTest {

    @Test
    public void payment_is_correct() {
        //Al tener una interfaz no podemos instanciar la clase por eso, usando Mockito podemos crearnos una simulacion de esa implementacion para probarla en el PaymentProcessor
        PaymentGateway paymentGateway = Mockito.mock(PaymentGateway.class);
        //El moquito any se usa para simular una parametro o solicitud cualquiera que necesite un metodo para funcionar, hay veces que se necesita castear el parametro que se vuelve el Mockito.any()
        Mockito.when(paymentGateway.requestPayment(Mockito.any())).thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));
        PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway);

        //Comprobacion del funcionamiento del pago
        assertTrue(paymentProcessor.makePayment(1000));
    }
    @Test
    public void payment_is_incorrect() {
        //Al tener una interfaz no podemos instanciar la clase por eso, usando Mockito podemos crearnos una simulacion de esa implementacion para probarla en el PaymentProcessor
        PaymentGateway paymentGateway = Mockito.mock(PaymentGateway.class);
        //El moquito any
        Mockito.when(paymentGateway.requestPayment(Mockito.any())).thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));
        PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway);

        //Comprobacion del funcionamiento del pago
        assertFalse(paymentProcessor.makePayment(1000));
    }
}