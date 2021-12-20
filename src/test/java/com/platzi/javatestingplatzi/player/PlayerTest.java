package com.platzi.javatestingplatzi.player;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PlayerTest {
    //Implementacion del test para el manejo del numero mas pequeñop
    @Test
    public void loses_when_dice_number_is_too_low(){
        //Creo un Mock del dado osea un simulado
        Dice dice = Mockito.mock(Dice.class);
        //Simulamos el dado en este caso forzamos el resultado
        Mockito.when(dice.roll()).thenReturn(2);

        Player player = new Player(dice,3);
        assertFalse(player.play());
    }
    //Test del ganador
    @Test
    public void wins_when_dice_number_is_big(){
        //Creo un Mock del dado osea un simulado
        Dice dice = Mockito.mock(Dice.class);
        //Simulamos el dado en este caso forzamos el resultado
        Mockito.when(dice.roll()).thenReturn(4);

        Player player = new Player(dice,3);
        assertTrue(player.play());
    }
    @Test
    public void loses_when_dice_number_is_equal(){
        //Creo un Mock del dado osea un simulado
        Dice dice = Mockito.mock(Dice.class);
        //Simulamos el dado en este caso forzamos el resultado
        Mockito.when(dice.roll()).thenReturn(3);

        Player player = new Player(dice,3);
        assertFalse(player.play());
    }
}