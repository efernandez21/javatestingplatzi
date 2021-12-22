package com.platzi.javatestingplatzi.discounts;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

public class PriceCalculatorShould {

    PriceCalculator calculator;

    @Before
    public void setup() {
        calculator = new PriceCalculator();
    }

    @Test
    public void total_zero_when_there_are_not_prices() {
        assertThat(calculator.getTotalFun(), is(0.0));
    }

    @Test
    public void total_is_the_sum_of_prices() {
        calculator.addPrice(10.2);
        calculator.addPrice(15.5);
        assertThat(calculator.getTotalFun(), is(25.7));
    }

    @Test
    public void apply_discount_to_prices() {

        calculator.addPrice(100);
        calculator.addPrice(50);
        calculator.addPrice(50);

        calculator.setDiscount(25);

        assertThat(calculator.getTotalFun(), is(150.0));
    }
}