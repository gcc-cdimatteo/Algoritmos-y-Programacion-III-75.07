package edu.fiuba.algo3.tp2N10;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderedChoiceTest {

    @Test
    public void OrderedChoicePuedeCrearseSiSeIndicanLasRtasCorretas() {
        RespuestaOrderedChoice respuestaCorrecta = new RespuestaOrderedChoice(Arrays.asList("A", "B", "C"));
        OrderedChoice preguntaOC = new OrderedChoice("El orden de las letras del abecedario es...", respuestaCorrecta);
        assertEquals(Collections.singletonList(1), preguntaOC.responder(Collections.singletonList(respuestaCorrecta)));
    }

    @Test
    public void OrderedChoiceRecibeUnaListaDeRespuestasYAsignaPuntosCorrectamente() {
        RespuestaOrderedChoice respuestaCorrecta = new RespuestaOrderedChoice(Arrays.asList("A", "B", "C"));
        RespuestaOrderedChoice respuestaIncorrecta = new RespuestaOrderedChoice(Arrays.asList("A", "C", "B"));
        OrderedChoice preguntaOC = new OrderedChoice("El orden de las letras del abecedario es...", respuestaCorrecta);
        List<Integer> expected = Arrays.asList(1, 0);
        assertEquals(expected, preguntaOC.responder(Arrays.asList(respuestaCorrecta, respuestaIncorrecta)));
    }
}
