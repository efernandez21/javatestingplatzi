package com.platzi.javatestingplatzi.util;

/**
 * Clase para la comprobacion de Password
 */
public class PasswordUtil {
    //Enumeracion de el nivel de seguridad, debido a los valores concretos posibles
    public enum SecurityLevel {
        WEAK, MEDIUM, STRONG
    }
    /**
     * Metodo que devuelve la fuerza del password
     * @param password el string del password
     * @return un enum de tipo SecurityLevel
     */
    public static SecurityLevel assessPassword(String password){
        if (password.length() <8 || password.matches("[a-zA-Z]+")){
            return SecurityLevel.WEAK;
        }
        if (password.matches("[a-zA-Z0-9]+")){
            return SecurityLevel.MEDIUM;
        }
        //En caso contrario tenemos un password fuerte
        return SecurityLevel.STRONG;
    }
}
