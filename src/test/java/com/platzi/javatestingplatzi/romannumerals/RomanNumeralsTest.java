package com.platzi.javatestingplatzi.romannumerals;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

public class RomanNumeralsTest {
    /*
        arabicToRoman(4) ⇒ "IV"
        arabicToRoman(9) ⇒ "IX"
        arabicToRoman(14) ⇒ "XIV"
        arabicToRoman(19) ⇒ "XIX"
        arabicToRoman(24) ⇒ "XXIV"
        arabicToRoman(40) ⇒ "XL"
        arabicToRoman(49) ⇒ "XLIX"
        arabicToRoman(90) ⇒ "XC"
        arabicToRoman(99) ⇒ "XCIX"
        arabicToRoman(400) ⇒ "CD"
        arabicToRoman(900) ⇒ "CM"
        Ten en cuenta que el símbolo I puede restar a V y X. El símbolo X puede restar a L y C. El símbolo C puede restar a D y M.
        Dicho de manera más simple, las combinaciones en las que hay una resta son las siguientes: IV IX XL XC CD CM.
     */
    @Test
    public void numbers_1_to_10() {
        assertThat(RomanNumerals.arabicToRoman2(1), is("I"));
        assertThat(RomanNumerals.arabicToRoman2(2), is("II"));
        assertThat(RomanNumerals.arabicToRoman2(3), is("III"));
        assertThat(RomanNumerals.arabicToRoman2(5), is("V"));
        assertThat(RomanNumerals.arabicToRoman2(6), is("VI"));
        assertThat(RomanNumerals.arabicToRoman2(7), is("VII"));
        assertThat(RomanNumerals.arabicToRoman2(10), is("X"));
    }

    @Test
    public void numbers_with_a_min() {
        assertThat(RomanNumerals.arabicToRoman2(4), is("IV"));
        assertThat(RomanNumerals.arabicToRoman2(9), is("IX"));
        assertThat(RomanNumerals.arabicToRoman2(14), is("XIV"));
        assertThat(RomanNumerals.arabicToRoman2(19), is("XIX"));
        assertThat(RomanNumerals.arabicToRoman2(24), is("XXIV"));
        assertThat(RomanNumerals.arabicToRoman2(40), is("XL"));
        assertThat(RomanNumerals.arabicToRoman2(49), is("XLIX"));
        assertThat(RomanNumerals.arabicToRoman2(90), is("XC"));
        assertThat(RomanNumerals.arabicToRoman2(99), is("XCIX"));
        assertThat(RomanNumerals.arabicToRoman2(400), is("CD"));
        assertThat(RomanNumerals.arabicToRoman2(900), is("CM"));
    }

    @Test
    public void numbers_too_large() {
        assertThat(RomanNumerals.arabicToRoman2(85), is("LXXXV"));
        assertThat(RomanNumerals.arabicToRoman2(86), is("LXXXVI"));
        assertThat(RomanNumerals.arabicToRoman2(126), is("CXXVI"));
        assertThat(RomanNumerals.arabicToRoman2(2507), is("MMDVII"));
        assertThat(RomanNumerals.arabicToRoman2(3234), is("MMMCCXXXIV"));
    }
}