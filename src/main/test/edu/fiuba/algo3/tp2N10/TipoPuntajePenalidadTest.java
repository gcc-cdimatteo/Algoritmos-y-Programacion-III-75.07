package edu.fiuba.algo3.tp2N10;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TipoPuntajePenalidadTest {

    @Test
    public void tipoPuntajeConPenalidadPuntuaCorrectamente(){
        TipoPuntajePenalidad tipoPuntaje = new TipoPuntajePenalidad();
        assertEquals(1, tipoPuntaje.puntuar(new ArrayList<>(Arrays.asList(1,0))));
    }

    @Test
    public void tipoPuntajeConPenalidadPuntuaCorrectamenteConVariosAciertos(){
        TipoPuntajePenalidad tipoPuntaje = new TipoPuntajePenalidad();
        assertEquals(3, tipoPuntaje.puntuar(new ArrayList<>(Arrays.asList(3,0))));
    }

    @Test
    public void tipoPuntajeConPenalidadPuntuaCorrectamenteConUnError() {
        TipoPuntajePenalidad tipoPuntaje = new TipoPuntajePenalidad();
        assertEquals(-1, tipoPuntaje.puntuar(new ArrayList<>(Arrays.asList(0, 1))));
    }

    @Test
    public void tipoPuntajeConPenalidadPuntuaCorrectamenteConVariosErrores(){
        TipoPuntajePenalidad tipoPuntaje = new TipoPuntajePenalidad();
        assertEquals(-3, tipoPuntaje.puntuar(new ArrayList<>(Arrays.asList(0,3))));
    }

    @Test
    public void tipoPuntajeConPenalidadPuntuaCorrectamenteConVariosAciertosYErrores(){
        TipoPuntajePenalidad tipoPuntaje = new TipoPuntajePenalidad();
        assertEquals(1, tipoPuntaje.puntuar(new ArrayList<>(Arrays.asList(3,2))));
    }

    @Test
    public void tipoPuntajeConPenalidadPuntuaCorrectamenteSinAciertosNiErrores(){
        TipoPuntajePenalidad tipoPuntaje = new TipoPuntajePenalidad();
        assertEquals(0, tipoPuntaje.puntuar(new ArrayList<>(Arrays.asList(0,0))));
    }
}
