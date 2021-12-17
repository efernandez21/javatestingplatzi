package com.platzi.javatestingplatzi.payments;

//import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * En esta clase podemos definir campos privados o variables en la clase de test
 * que usaremos como campos de la clase test
 */

@RunWith(MockitoJUnitRunner.class)
public class PaymentProcessorTest {
    //Crea un Mock
    @Mock
    private PaymentGateway paymentGateway;
    //Crea una instancia de la clase y inyecta el mock que fue creado con la anotacion @Mock dentro de esta instancia
    @InjectMocks
    private PaymentProcessor paymentProcessor;

    /**
     * Ejecutara este metodo antes de cada metodo, esto regenera el escenario para cada test, no se necesitara
     * si se usa el @Mock y el @InjectMocks, si no se usa el @RunWith, se puede usar el  Mockito.initMocks(this)
     * en este metodo Before, esto asegura la creacion del Mock y su respectiva inyeccion
     */
    /*@Before
    public void setup(){
         Mockito.initMocks(this)
        //Al tener una interfaz no podemos instanciar la clase por eso, usando Mockito podemos crearnos una simulacion de esa implementacion para probarla en el PaymentProcessor
        paymentGateway = Mockito.mock(PaymentGateway.class);
        paymentProcessor = new PaymentProcessor(paymentGateway);
    }*/


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