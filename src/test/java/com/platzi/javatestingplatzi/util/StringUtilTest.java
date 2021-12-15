package com.platzi.javatestingplatzi.util;



import org.junit.Assert;
import org.junit.Test;

/**
 * Clase para testeado de lo ya contruido, tenemos un main para la prueba del metodo aqui en la clase de test
 */
public class StringUtilTest {

    @Test
    public  void testRepeat() {

        //Llamado a la funcion a probar
        //Usando la funcion assertEquals de Junit
        Assert.assertEquals("holaholahola",StringUtil.repeat("hola",3));
        Assert.assertEquals("hola", StringUtil.repeat("hola",1));
    }


}