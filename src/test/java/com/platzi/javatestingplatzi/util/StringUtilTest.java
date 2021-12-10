package com.platzi.javatestingplatzi.util;

//import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase para testeado de lo ya contruido, tenemos un main para la prueba del metodo aqui en la clase de test
 */
public class StringUtilTest {
    public static void main(String[] args) {
        //Llamado a la funcion a probar
        String result = StringUtil.repeat("hola",3);
        //Comprobacion del resultado con el if
        if (result.equals("holaholahola")){
            System.out.println("OK");
        }
        String result2 = StringUtil.repeat("hola",1);
        if (result2.equals("hola")){
            System.out.println("OK");
        }
    }
}