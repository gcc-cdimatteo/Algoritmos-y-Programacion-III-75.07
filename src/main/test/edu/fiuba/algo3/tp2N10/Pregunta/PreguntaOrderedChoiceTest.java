package edu.fiuba.algo3.tp2N10.Pregunta;

import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.PreguntaOrderedChoice;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaOrderedChoice;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaOrderedChoiceTest {

    private final List<Integer> opcionesCorrectas;
    private final PreguntaOrderedChoice preguntaOC;

    public PreguntaOrderedChoiceTest() {
        String enunciado = "El orden de las letras del abecedario es...";
        List<String> opciones = Arrays.asList("A", "B", "C");
        this.opcionesCorrectas = Arrays.asList(0, 1, 2);
        this.preguntaOC = new PreguntaOrderedChoice(enunciado, opciones, this.opcionesCorrectas);
    }

    @Test
    public void test01UnaPreguntaOCPuedeCrearseSiSeIndicanLasRtasCorretas() {
        RespuestaOrderedChoice respuestaCorrecta = new RespuestaOrderedChoice(this.opcionesCorrectas);
        assertEquals(Collections.singletonList(1), this.preguntaOC.responder(Collections.singletonList(respuestaCorrecta)));
    }

    @Test
    public void test02UnaPreguntaOCPuntua0SiSeRespondeMal() {
        RespuestaOrderedChoice unaRespuesta = new RespuestaOrderedChoice(Arrays.asList(2, 1, 0));
        assertEquals(Collections.singletonList(0), this.preguntaOC.responder(Collections.singletonList(unaRespuesta)));
    }

    @Test
    public void test03UnaPreguntaOCRecibeUnaListaDeRespuestasYAsignaPuntos() {
        RespuestaOrderedChoice respuestaCorrecta = new RespuestaOrderedChoice(this.opcionesCorrectas);
        RespuestaOrderedChoice respuestaIncorrecta = new RespuestaOrderedChoice(Arrays.asList(2, 1, 0));
        assertEquals(Arrays.asList(1, 0), this.preguntaOC.responder(Arrays.asList(respuestaCorrecta, respuestaIncorrecta)));
    }
}
