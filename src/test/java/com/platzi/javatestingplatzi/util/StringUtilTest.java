package com.platzi.javatestingplatzi.util;



import org.junit.Assert;
import org.junit.Test;

/**
 * Clase para testeado de lo ya contruido, tenemos un main para la prueba del metodo aqui en la clase de test
 */
public class StringUtilTest {

    @Test
    public  void repeat_string_once() {
        //Usando la funcion assertEquals de Junit
        Assert.assertEquals("hola", StringUtil.repeat("hola",1));
    }
    @Test
    public  void repeat_string_multiple_times() {
        //Llamado a la funcion a probar
        //Usando la funcion assertEquals de Junit
        Assert.assertEquals("holaholahola",StringUtil.repeat("hola",3));
    }
    //Comprobacion si se repite 0 veces
    @Test
    public void repeat_string_zero_times(){
        Assert.assertEquals("",StringUtil.repeat("hola",0));
    }
    //Test para repetir negativo, es algo inesperado y con lo que deberiamos retornar es una excepcion
    @Test(expected = IllegalArgumentException.class)
    public void repeat_string_negative_times(){
       StringUtil.repeat("hola",-1);
    }


}