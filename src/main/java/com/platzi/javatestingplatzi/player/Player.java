package com.platzi.javatestingplatzi.player;

public class Player {
    //Indicamos la propiedad  dado, como un tipo de inyeccion de dependencias
    private Dice dice;
    private int minNumberToWin;


    public Player(Dice dice, int minNumberToWin) {
        this.dice = dice;
        this.minNumberToWin = minNumberToWin;
    }

    /**
     * Indica que el jugador ha ganado
     * @return true o false dependiendo del desenlace del dado generado
     */
    public boolean play(){
        int diceNumber = dice.roll();
        return diceNumber > minNumberToWin;
    }
}
