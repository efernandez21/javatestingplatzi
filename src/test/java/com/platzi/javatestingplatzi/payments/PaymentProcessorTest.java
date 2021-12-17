package com.platzi.javatestingplatzi.payments;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

/**
 * En esta clase podemos definir campos privados o variables en la clase de test
 * que usaremos como campos de la clase test
 */
public class PaymentProcessorTest {

    private PaymentGateway paymentGateway;
    private PaymentProcessor paymentProcessor;

    /**
     * Ejecutara este metodo antes de cada metodo, esto regenera el escenario para cada test
     */
    @Before
    public void setup(){
        //Al tener una interfaz no podemos instanciar la clase por eso, usando Mockito podemos crearnos una simulacion de esa implementacion para probarla en el PaymentProcessor
        paymentGateway = Mockito.mock(PaymentGateway.class);
        paymentProcessor = new PaymentProcessor(paymentGateway);
    }


    @Test
    public void payment_is_correct() {
        //El moquito any se usa para simular una parametro o solicitud cualquiera que necesite un metodo para funcionar, hay veces que se necesita castear el parametro que se vuelve el Mockito.any()
        Mockito.when(paymentGateway.requestPayment(Mockito.any())).thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));
        //Comprobacion del funcionamiento del pago
        assertTrue(paymentProcessor.makePayment(1000));
    }
    @Test
    public void payment_is_incorrect() {
        //El moquito any
        Mockito.when(paymentGateway.requestPayment(Mockito.any())).thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));
        //Comprobacion del funcionamiento del pago
        assertFalse(paymentProcessor.makePayment(1000));
    }
}