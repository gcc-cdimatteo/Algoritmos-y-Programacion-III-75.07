package edu.fiuba.algo3.tp2N10;

import edu.fiuba.algo3.tp2N10.Pregunta.PreguntaOrderedChoice;
import edu.fiuba.algo3.tp2N10.Respuesta.RespuestaOrderedChoice;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaOrderedChoiceTest {

    private String enunciado;
    private List<String> opciones;
    private List<Integer> opcionesCorrectas;
    private PreguntaOrderedChoice preguntaOC;

    public PreguntaOrderedChoiceTest() {
        this.enunciado = "El orden de las letras del abecedario es...";
        this.opciones = Arrays.asList("A", "B", "C");
        this.opcionesCorrectas = Arrays.asList(1, 2, 3);
        this.preguntaOC = new PreguntaOrderedChoice(this.enunciado, this.opciones, this.opcionesCorrectas);
    }

    @Test
    public void OrderedChoicePuedeCrearseSiSeIndicanLasRtasCorretas() {
        RespuestaOrderedChoice respuestaCorrecta = new RespuestaOrderedChoice(this.opcionesCorrectas);
        assertEquals(Collections.singletonList(1), this.preguntaOC.responder(Arrays.asList(respuestaCorrecta)));
    }

    @Test
    public void OrderedChoiceRecibeUnaListaDeRespuestasYAsignaPuntosCorrectamente() {
        RespuestaOrderedChoice respuestaCorrecta = new RespuestaOrderedChoice(this.opcionesCorrectas);
        RespuestaOrderedChoice respuestaIncorrecta = new RespuestaOrderedChoice(Arrays.asList(3, 2, 1));
        assertEquals(Arrays.asList(1, 0), this.preguntaOC.responder(Arrays.asList(respuestaCorrecta, respuestaIncorrecta)));
    }

}
