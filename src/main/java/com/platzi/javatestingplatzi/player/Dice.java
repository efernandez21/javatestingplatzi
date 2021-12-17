package com.platzi.javatestingplatzi.player;

import java.util.Random;

public class Dice {
    private int sides;

    public Dice(int sides) {
        this.sides = sides;
    }

    /**
     * Metodo para lanzar el dado, dependiendo de las caras obtendremos un resultado
     * @return el numero obtenido al lanzarlo
     */
    public int roll(){
        //definimos el numero limite de caras
        return new Random().nextInt(sides)+1;
    }
}
