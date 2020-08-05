package edu.fiuba.algo3.tp2N10;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerdaderoFalsoTest {

    @Test
    public void verdaderoFalsoClasicoPuedeCrearseSiSeIndicaLaRtaCorreta(){
        RespuestaVerdaderoFalso respuestaCorrecta = new RespuestaVerdaderoFalso(false);
        VerdaderoFalso preguntaVF = new VerdaderoFalso("La manzana es azul",respuestaCorrecta);
        ArrayList<Integer> expected = new ArrayList<>(Collections.singletonList(1));
        assertEquals(expected, preguntaVF.responder(new ArrayList<>(Collections.singletonList(respuestaCorrecta))));
    }

    @Test
    public void verdaderoFalsoConPenalidadDevuelvePuntajeCorrecto(){
        RespuestaVerdaderoFalso respuestaCorrecta = new RespuestaVerdaderoFalso(false);
        RespuestaVerdaderoFalso respuestaIncorrecta = new RespuestaVerdaderoFalso(true);
        VerdaderoFalso preguntaVF = VerdaderoFalso.VerdaderoFalsoPenalidad("La manzana es azul",respuestaCorrecta);
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, -1));
        assertEquals(expected, preguntaVF.responder(new ArrayList<>(Arrays.asList(respuestaCorrecta, respuestaIncorrecta))));
    }

}