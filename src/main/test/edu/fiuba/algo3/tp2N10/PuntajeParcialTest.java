package edu.fiuba.algo3.tp2N10;

import edu.fiuba.algo3.tp2N10.Puntaje.PuntajeParcial;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntajeParcialTest {

    @Test
    public void tipoPuntajeConParcialPuntuaCorrectamente(){
        PuntajeParcial tipoPuntaje = new PuntajeParcial();
        assertEquals(1, tipoPuntaje.puntuar(new ArrayList<>(Arrays.asList(1,0))));
    }

    @Test
    public void tipoPuntajeConParcialPuntuaCorrectamenteConVariosAciertos(){
        PuntajeParcial tipoPuntaje = new PuntajeParcial();
        assertEquals(3, tipoPuntaje.puntuar(new ArrayList<>(Arrays.asList(3,0))));
    }

    @Test
    public void tipoPuntajeConParcialPuntuaCorrectamenteConUnError() {
        PuntajeParcial tipoPuntaje = new PuntajeParcial();
        assertEquals(0, tipoPuntaje.puntuar(new ArrayList<>(Arrays.asList(0, 1))));
    }

    @Test
    public void tipoPuntajeConParcialPuntuaCorrectamenteConVariosErrores(){
        PuntajeParcial tipoPuntaje = new PuntajeParcial();
        assertEquals(0, tipoPuntaje.puntuar(new ArrayList<>(Arrays.asList(0,3))));
    }

    @Test
    public void tipoPuntajeConParcialPuntuaCorrectamenteConVariosAciertosYErrores(){
        PuntajeParcial tipoPuntaje = new PuntajeParcial();
        assertEquals(0, tipoPuntaje.puntuar(new ArrayList<>(Arrays.asList(3,2))));
    }

    @Test
    public void tipoPuntajeConParcialPuntuaCorrectamenteSinAciertosNiErrores(){
        PuntajeParcial tipoPuntaje = new PuntajeParcial();
        assertEquals(0, tipoPuntaje.puntuar(new ArrayList<>(Arrays.asList(0,0))));
    }
}