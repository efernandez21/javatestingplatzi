package com.platzi.javatestingplatzi.util;

public class StringUtil {
    /**
     * Funcion para repetir strings
     * @param str string o cadena a repetir
     * @param times numero de veces a repetir
     * @return
     */
    public static String repeat(String str, int times){
        String result = "";
        for (int i = 0; i < times; i++) {
            result += str;
        }
        return result;
    }
}
