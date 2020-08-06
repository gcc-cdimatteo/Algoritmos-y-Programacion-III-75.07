package edu.fiuba.algo3.tp2N10;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderedChoiceTest {

    @Test
    public void OrderedChoicePuedeCrearseSiSeIndicanLasRtasCorretas() {
        RespuestaOrderedChoice respuestaCorrecta = new RespuestaOrderedChoice(new ArrayList<>(Arrays.asList("A", "B", "C")));
        OrderedChoice preguntaOC = new OrderedChoice("El orden de las letras del abecedario es...", respuestaCorrecta);
        assertEquals(Collections.singletonList(1), preguntaOC.responder(new ArrayList<>(Collections.singletonList(respuestaCorrecta))));
    }

    @Test
    public void OrderedChoiceRecibeUnaListaDeRespuestasYAsignaPuntos() {
        RespuestaOrderedChoice respuestaCorrecta = new RespuestaOrderedChoice(Arrays.asList("A", "B", "C"));
        RespuestaOrderedChoice respuestaIncorrecta = new RespuestaOrderedChoice(Arrays.asList("A", "B", "C"));
        OrderedChoice preguntaOC = new OrderedChoice("El orden de las letras del abecedario es...", respuestaCorrecta);
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 0));
        assertEquals(expected, preguntaOC.responder(Arrays.asList(respuestaCorrecta, respuestaIncorrecta)));
    }

}
