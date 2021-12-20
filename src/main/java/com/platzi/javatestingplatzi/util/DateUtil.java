package com.platzi.javatestingplatzi.util;

public class DateUtil {
    /**
     * Metodo para comprobar si un año es bisiesto
     * @param year año a comprobar
     * @return true or false dependiendo de si el año es bisiesto
     */
    public static boolean isLeapYear(int year){
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
