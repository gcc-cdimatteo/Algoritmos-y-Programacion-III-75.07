package edu.fiuba.algo3.tp2N10.Pregunta;

import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.PreguntaMultipleChoice;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaMultipleChoice;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoiceTest {

    private final String enunciado;
    private final List<String> opciones;
    private final Set<Integer> opcionesCorrectas;
    private PreguntaMultipleChoice preguntaMC;

    public PreguntaMultipleChoiceTest() {
        this.enunciado = "La manzana es...";
        this.opciones = Arrays.asList("una fruta", "roja", "verde", "un citrico", "azul");
        this.opcionesCorrectas = new HashSet<>(Arrays.asList(0, 1, 2));
    }

    private void crearMultipleChoiceClasico() {
        this.preguntaMC = PreguntaMultipleChoice.Clasico(this.enunciado, this.opciones, this.opcionesCorrectas);
    }

    private void crearMultipleChoiceParcial() {
        this.preguntaMC = PreguntaMultipleChoice.Parcial(this.enunciado, this.opciones, this.opcionesCorrectas);
    }

    private void crearMultipleChoicePenalidad() {
        this.preguntaMC = PreguntaMultipleChoice.Penalidad(this.enunciado, this.opciones, this.opcionesCorrectas);
    }

    // Clasico
    @Test
    public void test01UnaPreguntaMCClasicoPuedeCrearseSiSeIndicanLasRtasCorretas() {
        crearMultipleChoiceClasico();
        RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice(this.opcionesCorrectas);
        assertEquals(Collections.singletonList(1), this.preguntaMC.responder(Collections.singletonList(respuesta)));
    }

    @Test
    public void test02UnaPreguntaMCClasicoRecibeUnaListaDeRespuestasYAsignaPuntos() {
        crearMultipleChoiceClasico();
        RespuestaMultipleChoice respuestaCorrecta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(2, 0, 1)));
        RespuestaMultipleChoice respuestaIncorrecta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(4, 3)));
        assertEquals(Arrays.asList(1, 0), this.preguntaMC.responder(Arrays.asList(respuestaCorrecta, respuestaIncorrecta)));
    }

    // Parcial
    @Test
    public void test03UnaPreguntaMCParcialPuedeCrearseSiSeIndicanLasRtasCorretas() {
        crearMultipleChoiceParcial();
        RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(2, 1, 0)));
        assertEquals(Collections.singletonList(3), this.preguntaMC.responder(Collections.singletonList(respuesta)));
    }

    @Test
    public void test04UnaPreguntaMCParcialRecibeUnaListaDeRespuestasYAsignaPuntos() {
        crearMultipleChoiceParcial();
        RespuestaMultipleChoice respuestaCorrecta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(2, 1, 0)));
        RespuestaMultipleChoice respuestaIncorrecta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(4, 1, 3)));
        assertEquals(Arrays.asList(3, 0), this.preguntaMC.responder(Arrays.asList(respuestaCorrecta, respuestaIncorrecta)));
    }

    // Penalidad
    @Test
    public void test05UnaPreguntaMCPenalidadPuedeCrearseSiSeIndicanLasRtasCorretas() {
        crearMultipleChoicePenalidad();
        RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(2, 0, 1)));
        assertEquals(Collections.singletonList(3), this.preguntaMC.responder(Collections.singletonList(respuesta)));
    }

    @Test
    public void test06UnaPreguntaMCPenalidadRecibeUnaListaDeRespuestasYAsignaPuntos() {
        crearMultipleChoicePenalidad();
        RespuestaMultipleChoice respuestaCorrecta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(2, 0, 1)));
        RespuestaMultipleChoice respuestaIncorrecta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(2, 4, 1)));
        assertEquals(Arrays.asList(3, 1), this.preguntaMC.responder(Arrays.asList(respuestaCorrecta, respuestaIncorrecta)));
    }
}