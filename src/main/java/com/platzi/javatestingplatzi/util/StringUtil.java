package com.platzi.javatestingplatzi.util;

public class StringUtil {
    /**
     * Funcion para repetir strings
     * @param str string o cadena a repetir
     * @param times numero de veces a repetir
     * @return el string repetido
     */
    public static String repeat(String str, int times){
        //Comprobacion si el numero de veces es negativo
        if (times <0){
            throw new IllegalArgumentException("negative times not allowed");
        }
        StringBuilder result = new StringBuilder();  /*Otra forma de Hacer funcionar con mejor codigo*/
        //String result = "";
        for (int i = 0; i < times; i++) {
            //result += str;
            result.append(str);  /*Usado con el StringBuilder*/
        }
        return result.toString();/*Usado con el StringBuilder*/
        //return result;
    }

    /**
     * Metodo para revisar si un String esta vacio
     * @param str el string a comprobar si es vacio
     * @return true si es vacio, false si no lo es
     */
    public static boolean isEmpty(String str){

        return str == null || str.trim().length() == 0;
    }
}
