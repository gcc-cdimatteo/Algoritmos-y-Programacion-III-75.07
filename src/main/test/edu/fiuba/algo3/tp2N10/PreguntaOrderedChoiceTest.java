package edu.fiuba.algo3.tp2N10;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaOrderedChoiceTest {

    private final Enunciado miEnunciado = new Enunciado("El orden de las letras del abecedario es...", Arrays.asList("A", "C", "B"));
    private final RespuestaOrderedChoice respuestaCorrecta = new RespuestaOrderedChoice(Arrays.asList("A", "B", "C"));
    private final RespuestaOrderedChoice respuestaIncorrecta = new RespuestaOrderedChoice(Arrays.asList("A", "C", "B"));
    private final PreguntaOrderedChoice preguntaOC = new PreguntaOrderedChoice(this.miEnunciado, this.respuestaCorrecta);

    @Test
    public void OrderedChoicePuedeCrearseSiSeIndicanLasRtasCorretas() {
        assertEquals(Collections.singletonList(1), this.preguntaOC.responder(Collections.singletonList(respuestaCorrecta)));
    }

    @Test
    public void OrderedChoiceRecibeUnaListaDeRespuestasYAsignaPuntosCorrectamente() {
        assertEquals(Arrays.asList(1, 0), this.preguntaOC.responder(Arrays.asList(this.respuestaCorrecta, this.respuestaIncorrecta)));
    }
}
