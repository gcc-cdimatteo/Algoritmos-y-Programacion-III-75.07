package edu.fiuba.algo3.tp2N10;

import edu.fiuba.algo3.tp2N10.Modelo.Puntaje.PuntajePenalidad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntajePenalidadTest {

    @Test
    public void tipoPuntajeConPenalidadPuntuaCorrectamente(){
        PuntajePenalidad tipoPuntaje = new PuntajePenalidad();
        assertEquals(1, tipoPuntaje.puntuar(1,0));
    }

    @Test
    public void tipoPuntajeConPenalidadPuntuaCorrectamenteConVariosAciertos(){
        PuntajePenalidad tipoPuntaje = new PuntajePenalidad();
        assertEquals(3, tipoPuntaje.puntuar(3,0));
    }

    @Test
    public void tipoPuntajeConPenalidadPuntuaCorrectamenteConUnError() {
        PuntajePenalidad tipoPuntaje = new PuntajePenalidad();
        assertEquals(-1, tipoPuntaje.puntuar(0, 1));
    }

    @Test
    public void tipoPuntajeConPenalidadPuntuaCorrectamenteConVariosErrores(){
        PuntajePenalidad tipoPuntaje = new PuntajePenalidad();
        assertEquals(-3, tipoPuntaje.puntuar(0,3));
    }

    @Test
    public void tipoPuntajeConPenalidadPuntuaCorrectamenteConVariosAciertosYErrores(){
        PuntajePenalidad tipoPuntaje = new PuntajePenalidad();
        assertEquals(1, tipoPuntaje.puntuar(3,2));
    }

    @Test
    public void tipoPuntajeConPenalidadPuntuaCorrectamenteSinAciertosNiErrores(){
        PuntajePenalidad tipoPuntaje = new PuntajePenalidad();
        assertEquals(0, tipoPuntaje.puntuar(0,0));
    }
}
