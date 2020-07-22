package edu.fiuba.algo3.tp2N10;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TP2Test {

    @Test
    public void unaPreguntaDeVFPuedeCrearseSiSeIndicaLaRtaCorreta(){
        PreguntaVF unaPregunta = new PreguntaVF("Una manzana es una fruta", true);
        assertEquals(1, unaPregunta.puntuar(true));
    }

    @Test
    public void unaPreguntaDeVFRecibeRespuestasYAsignaPuntos(){
        ArrayList<Boolean> respuestas = new ArrayList<Boolean>();
        ArrayList<Integer> puntos;
        ArrayList<Integer> puntosEsperados = new ArrayList<Integer>();
        respuestas.add(true);
        respuestas.add(false);
        PreguntaVF unaPregunta = new PreguntaVF("Una manzana es una fruta", true);
        puntos = unaPregunta.responder(respuestas);
        puntosEsperados.add(1);
        puntosEsperados.add(0);
        assertTrue(puntos.equals(puntosEsperados));
    }

}