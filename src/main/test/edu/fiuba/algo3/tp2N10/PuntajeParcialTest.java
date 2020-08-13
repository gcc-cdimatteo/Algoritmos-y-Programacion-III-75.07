package edu.fiuba.algo3.tp2N10;

import edu.fiuba.algo3.tp2N10.Modelo.Puntaje.PuntajeParcial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntajeParcialTest {

    @Test
    public void tipoPuntajeConParcialPuntuaCorrectamente(){
        PuntajeParcial tipoPuntaje = new PuntajeParcial();
        assertEquals(1, tipoPuntaje.puntuar(1,0));
    }

    @Test
    public void tipoPuntajeConParcialPuntuaCorrectamenteConVariosAciertos(){
        PuntajeParcial tipoPuntaje = new PuntajeParcial();
        assertEquals(3, tipoPuntaje.puntuar(3,0));
    }

    @Test
    public void tipoPuntajeConParcialPuntuaCorrectamenteConUnError() {
        PuntajeParcial tipoPuntaje = new PuntajeParcial();
        assertEquals(0, tipoPuntaje.puntuar(0, 1));
    }

    @Test
    public void tipoPuntajeConParcialPuntuaCorrectamenteConVariosErrores(){
        PuntajeParcial tipoPuntaje = new PuntajeParcial();
        assertEquals(0, tipoPuntaje.puntuar(1,3));
    }

    @Test
    public void tipoPuntajeConParcialPuntuaCorrectamenteConVariosAciertosYErrores(){
        PuntajeParcial tipoPuntaje = new PuntajeParcial();
        assertEquals(0, tipoPuntaje.puntuar(3,2));
    }

    @Test
    public void tipoPuntajeConParcialPuntuaCorrectamenteSinAciertosNiErrores(){
        PuntajeParcial tipoPuntaje = new PuntajeParcial();
        assertEquals(0, tipoPuntaje.puntuar(0,0));
    }
}