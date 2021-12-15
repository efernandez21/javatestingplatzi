package com.platzi.javatestingplatzi.util;


//import static org.junit.Assert.*;
/**
 * Clase para testeado de lo ya contruido, tenemos un main para la prueba del metodo aqui en la clase de test
 */
public class StringUtilTest {
    public static void main(String[] args) {
        //Llamado a la funcion a probar
        //Usando el metodo creado sin el de Junit
        assertEquals(StringUtil.repeat("hola",3),"holaholahola");
        assertEquals(StringUtil.repeat("hola",1),"hola");
    }

    /**
     * Autodefinicion del metodo assertEquals sin hacer uso del JUnit
     * @param actual valor actual
     * @param expected valor esperado o el correcto
     */
    private static void assertEquals(String actual, String expected) {
        //Comprobacion del resultado con el if
        if (!actual.equals(expected)){
            throw new RuntimeException(actual +" is not Equal than "+expected);
        }
    }
}