package edu.fiuba.algo3.tp2N10;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TP2Test {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Entrega0
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void unaPreguntaDeVFPuedeCrearseSiSeIndicaLaRtaCorreta(){
        Respuesta respuestaCorrecta = new Respuesta(true);
        PreguntaVF unaPregunta = new PreguntaVF("Una manzana es una fruta", respuestaCorrecta);
        assertEquals(1, unaPregunta.puntuar(respuestaCorrecta));
    }

    @Test
    public void unaPreguntaDeVFRecibeRespuestasYAsignaPuntos(){
        Respuesta respuestaCorrecta = new Respuesta(true);
        Respuesta respuestaIncorrecta = new Respuesta(false);
        ArrayList<Respuesta> respuestas = new ArrayList();
        respuestas.add(respuestaCorrecta);
        respuestas.add(respuestaIncorrecta);
        PreguntaVF unaPregunta = new PreguntaVF("Una manzana es una fruta", respuestaCorrecta);
        ArrayList<Integer> puntosEsperados = new ArrayList();
        puntosEsperados.add(1);
        puntosEsperados.add(0);
        ArrayList<Integer> puntos = unaPregunta.responder(respuestas);
        assertTrue(puntos.equals(puntosEsperados));
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Entrega1
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void unaPreguntaDeVFConPenalidadPuedeCrearseSiSeIndicaLaRtaCorreta(){
        Respuesta respuestaCorrecta = new Respuesta(true);
        PreguntaVFConPenalidad unaPregunta = new PreguntaVFConPenalidad("Una manzana es una fruta", respuestaCorrecta);
        assertEquals(1, unaPregunta.puntuar(respuestaCorrecta));
    }

    @Test
    public void unaPreguntaDeVFConPenalidadRestaUnPuntoSiSeRespondeMal(){
        Respuesta respuestaCorrecta = new Respuesta(true);
        PreguntaVFConPenalidad unaPregunta = new PreguntaVFConPenalidad("Una manzana es una fruta", respuestaCorrecta);
        Respuesta respuestaIncorrecta = new Respuesta(false);
        assertEquals(-1, unaPregunta.puntuar(respuestaIncorrecta));
    }

    @Test
    public void unaPreguntaDeMCPuedeCrearseSiSeIndicaLasRtasCorretas(){
        Respuesta respuestaCorrectaUno = new Respuesta("Una fruta");
        Respuesta respuestaCorrectaDos = new Respuesta("De color rojo");
        Respuesta respuestaCorrectaTres = new Respuesta("Muy rica");
        ArrayList<Respuesta> respuestasCorrectas = new ArrayList();
        respuestasCorrectas.add(respuestaCorrectaUno);
        respuestasCorrectas.add(respuestaCorrectaDos);
        respuestasCorrectas.add(respuestaCorrectaTres);
        PreguntaMC unaPregunta = new PreguntaMC("Una manzana es", respuestasCorrectas);
        assertEquals(1, unaPregunta.puntuar(respuestasCorrectas));
    }

    @Test
    public void unaPreguntaDeMCPuntuaCon0SiUnaRespuestaEsIncorrecta(){
        Respuesta respuestaCorrectaUno = new Respuesta("Una fruta");
        Respuesta respuestaCorrectaDos = new Respuesta("De color rojo");
        Respuesta respuestaCorrectaTres = new Respuesta("Muy rica");
        Respuesta respuestaIncorrecta = new Respuesta("Un citrico");
        ArrayList<Respuesta> respuestasCorrectas = new ArrayList();
        respuestasCorrectas.add(respuestaCorrectaUno);
        respuestasCorrectas.add(respuestaCorrectaDos);
        respuestasCorrectas.add(respuestaCorrectaTres);
        PreguntaMC unaPregunta = new PreguntaMC("Una manzana es", respuestasCorrectas);
        ArrayList<Respuesta> respuestas = new ArrayList();
        respuestas.add(respuestaCorrectaUno);
        respuestas.add(respuestaCorrectaDos);
        respuestas.add(respuestaCorrectaTres);
        respuestas.add(respuestaIncorrecta);
        assertEquals(0, unaPregunta.puntuar(respuestas));
    }


}