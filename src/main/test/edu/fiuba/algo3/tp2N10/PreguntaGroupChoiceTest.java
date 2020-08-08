package edu.fiuba.algo3.tp2N10;

import edu.fiuba.algo3.tp2N10.Pregunta.PreguntaGroupChoice;
import edu.fiuba.algo3.tp2N10.Respuesta.RespuestaGroupChoice;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaGroupChoiceTest {

    private String enunciado;
    private List<String> opciones;
    private Set<Integer> opcionesGrupoA;
    private Set<Integer> opcionesGrupoB;
    private PreguntaGroupChoice preguntaGC;

    public PreguntaGroupChoiceTest(){
        this.enunciado = "Ordene las opciones en los grupos correctos...";
        this.opciones = Arrays.asList("A", "1", "B", "2");
        this.opcionesGrupoA = new HashSet<>(Arrays.asList(0, 2));
        this.opcionesGrupoB = new HashSet<>(Arrays.asList(1, 3));
        this.preguntaGC = new PreguntaGroupChoice(enunciado, opciones, opcionesGrupoA, opcionesGrupoB);
    }

    @Test
    public void GroupChoicePuedeCrearseSiSeIndicanLasRtasCorretas() {
        RespuestaGroupChoice respuestaCorrecta = new RespuestaGroupChoice(this.opcionesGrupoA, this.opcionesGrupoB);
        assertEquals(Collections.singletonList(1), this.preguntaGC.responder(Arrays.asList(respuestaCorrecta)));
    }

    @Test
    public void GroupChoiceRecibeUnaListaDeRespuestasYAsignaPuntos() {
        Set<Integer> opcionesGrupoC = new HashSet<>(Arrays.asList(0, 1));
        Set<Integer> opcionesGrupoD = new HashSet<>(Arrays.asList(2, 3));
        RespuestaGroupChoice respuestaCorrecta = new RespuestaGroupChoice(this.opcionesGrupoA, this.opcionesGrupoB);
        RespuestaGroupChoice respuestaIncorrecta = new RespuestaGroupChoice(opcionesGrupoC, opcionesGrupoD);
        assertEquals(Arrays.asList(1, 0), this.preguntaGC.responder(Arrays.asList(respuestaCorrecta, respuestaIncorrecta)));
    }
}
