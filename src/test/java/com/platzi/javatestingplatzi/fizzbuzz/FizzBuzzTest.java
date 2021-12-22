package com.platzi.javatestingplatzi.fizzbuzz;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

public class FizzBuzzTest {

    /*
        Usando TDD (empieza por los tests), implementa una función que dado un número:
        Si el número es divisible por 3, retorna “Fizz”
        Si el número es divisible por 5, retorna “Buzz”
        Si el número es divisible por 3 y por 5, retorna “FizzBuzz”
        En otro caso, retorna el mismo número
     */

    @Test
    public void is_divisible_by_3_but_not_for_5() {
        assertThat(FizzBuzz.fizzBuzz(3),is("Fizz"));
        assertThat(FizzBuzz.fizzBuzz(6),is("Fizz"));
    }
    @Test
    public void is_divisible_by_5_but_not_for_3() {
        assertThat(FizzBuzz.fizzBuzz(5),is("Buzz"));
        assertThat(FizzBuzz.fizzBuzz(10),is("Buzz"));
    }

    @Test
    public void is_divisible_by_3_and_5() {
        assertThat(FizzBuzz.fizzBuzz(15),is("FizzBuzz"));
        assertThat(FizzBuzz.fizzBuzz(30),is("FizzBuzz"));
    }

    @Test
    public void is_not_divisible() {
        assertThat(FizzBuzz.fizzBuzz(2),is("2"));
        assertThat(FizzBuzz.fizzBuzz(16),is("16"));
    }
}