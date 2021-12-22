package com.platzi.javatestingplatzi.fizzbuzz;

public class FizzBuzz {
    /**
     * Metodo para devolver un String determinado en caso de un parametro numerico recibido
     * @param n numero entero a comprobar
     * @return Fizz o Buzz ó FizzBuzz segun sea el caso
     */
    public static String fizzBuzz(int n) {
        if (n % 3 == 0){
            if (n % 5 ==0){
                return "FizzBuzz";
            }
            return "Fizz";
        } else if (n % 5 == 0){
            return "Buzz";
        } else {
            return Integer.toString(n);
        }

    }
}
