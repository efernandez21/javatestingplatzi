package com.platzi.javatestingplatzi.romannumerals;

import java.util.Arrays;
import java.util.List;

public class RomanNumerals {
    enum RomanNumeral {

        M(1000),CM(900),D(500),CD(400),
        C(100),XC(90),L(50),XL(40),
        X(10),IX(9),V(5),IV(4),
        I(1);

        private int value;

        RomanNumeral(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static List<RomanNumeral> getRomanNumerals() {
            return Arrays.asList(RomanNumeral.values());
        }

    }

    public static String arabicToRoman2(int n) {

        StringBuilder collator = new StringBuilder();
        List<RomanNumeral> romanNumerals= RomanNumeral.getRomanNumerals();

        //Valida que el número sea menor a 4000 debido a que el formato cambia
        if (n > 0 && n < 4000) {

            int i = 0;
            while(n>0 && i<romanNumerals.size()){
                RomanNumeral currentRoman = romanNumerals.get(i);
                if(n>=currentRoman.getValue()){
                    collator.append(currentRoman);
                    n -= currentRoman.getValue();
                } else {
                    i++;
                }

            }

            return collator.toString();

        } else {
            throw new IllegalArgumentException( n + "no está en el rango (0,4000)");
        }
    }
    public static String arabicToRoman(int n) {
        String result = "";

        for (int i = 0; i < n; i++) {
            //Mejor Usar el StringBuilder
            result += "I";

            result = result.replaceAll("IIII", "IV");
            result = result.replaceAll("IVI", "V");

            result = result.replaceAll("VIV", "IX");
            result = result.replaceAll("IXI", "X");

            result = result.replaceAll("XXXX", "XL");
            result = result.replaceAll("XLX", "L");

            result = result.replaceAll("LXL", "XC");
            result = result.replaceAll("XCX", "C");

            result = result.replaceAll("CCCC", "CD");
            result = result.replaceAll("CDC", "D");

            result = result.replaceAll("DCD", "CM");
            result = result.replaceAll("CMC", "M");
        }
        return result;
    }

}
