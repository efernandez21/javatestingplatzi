package com.platzi.javatestingplatzi.util;

import org.junit.Test;

import static com.platzi.javatestingplatzi.util.PasswordUtil.*;
import static org.junit.Assert.*;

/**
 * Clase para testear la fuerza del password, en el caso de si es Fuerte, Medio o Debil
 */
public class PasswordUtilTest {
    //Tests de comprobacion con JUNIT para mis clases recien creadas
    @Test
    public void weak_when_has_less_than_8_letters() {
        assertEquals(SecurityLevel.WEAK,PasswordUtil.assessPassword("123aa!"));
    }
    @Test
    public void weak_when_has_only_letters() {
        assertEquals(SecurityLevel.WEAK,PasswordUtil.assessPassword("abcdefghdsfsdf"));
    }
    @Test
    public void medium_when_has_letters_and_numbers() {
        assertEquals(SecurityLevel.MEDIUM,PasswordUtil.assessPassword("abcds12343"));
    }
    @Test
    public void strong_when_has_letters_numbers_and_symbols() {
        assertEquals(SecurityLevel.STRONG,PasswordUtil.assessPassword("abcd123!"));
    }
}