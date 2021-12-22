package com.platzi.javatestingplatzi.discounts;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Clase para el calculo del total del precio y descuentos de productos dados
 */
public class PriceCalculator {

    private List<Double> prices = new ArrayList<>();
    private double discount;

    /**
     * Calculo del total de precios, teniendo en cuenta un descuento dado por defecto sera cero
     * @return el total
     */
    public double getTotal() {
        double result = 0;
        for (Double price: prices) {
            result += price;
        }
        return result * (1 - (discount /100));

    }

    /**
     * Calculo precios pero usando programacion Funcional
     * @return el total a cobrar
     */
    public double getTotalFun() {
        Double total = prices.stream().reduce(Double::sum).orElse(0.0);
        //Double total = prices.stream().reduce(0.0,Double::sum);
        return total * (1 - (discount /100));

    }

    /**
     * Añadimos un nuevo precio
     * @param price el precio a añadir
     */
    public void addPrice(double price) {
        prices.add(price);
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
