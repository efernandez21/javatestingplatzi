package com.platzi.javatestingplatzi.fizzbuzz;

public class FizzBuzz {
    /**
     * Metodo para devolver un String determinado en caso de un parametro numerico recibido
     * @param n numero entero a comprobar
     * @return Fizz o Buzz ó FizzBuzz segun sea el caso
     */
    public static String fizzBuzz(int n) {

        return (n % 3 == 0 )? (n % 5 == 0)? "FizzBuzz" : "Fizz"  : (n % 5 == 0)?"Buzz":String.valueOf(n);

    }
}
