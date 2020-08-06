package edu.fiuba.algo3.tp2N10;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TipoPuntajeParcialTest {

    @Test
    public void tipoPuntajeConParcialPuntuaCorrectamente(){
        TipoPuntajeParcial tipoPuntaje = new TipoPuntajeParcial();
        assertEquals(1, tipoPuntaje.puntuar(new ArrayList<>(Arrays.asList(1,0))));
    }

    @Test
    public void tipoPuntajeConParcialPuntuaCorrectamenteConVariosAciertos(){
        TipoPuntajeParcial tipoPuntaje = new TipoPuntajeParcial();
        assertEquals(3, tipoPuntaje.puntuar(new ArrayList<>(Arrays.asList(3,0))));
    }

    @Test
    public void tipoPuntajeConParcialPuntuaCorrectamenteConUnError() {
        TipoPuntajeParcial tipoPuntaje = new TipoPuntajeParcial();
        assertEquals(0, tipoPuntaje.puntuar(new ArrayList<>(Arrays.asList(0, 1))));
    }

    @Test
    public void tipoPuntajeConParcialPuntuaCorrectamenteConVariosErrores(){
        TipoPuntajeParcial tipoPuntaje = new TipoPuntajeParcial();
        assertEquals(0, tipoPuntaje.puntuar(new ArrayList<>(Arrays.asList(0,3))));
    }

    @Test
    public void tipoPuntajeConParcialPuntuaCorrectamenteConVariosAciertosYErrores(){
        TipoPuntajeParcial tipoPuntaje = new TipoPuntajeParcial();
        assertEquals(0, tipoPuntaje.puntuar(new ArrayList<>(Arrays.asList(3,2))));
    }

    @Test
    public void tipoPuntajeConParcialPuntuaCorrectamenteSinAciertosNiErrores(){
        TipoPuntajeParcial tipoPuntaje = new TipoPuntajeParcial();
        assertEquals(0, tipoPuntaje.puntuar(new ArrayList<>(Arrays.asList(0,0))));
    }
}