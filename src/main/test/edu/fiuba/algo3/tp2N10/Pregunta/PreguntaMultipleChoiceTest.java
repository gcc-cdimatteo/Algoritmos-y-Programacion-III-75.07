package edu.fiuba.algo3.tp2N10.Pregunta;

import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.PreguntaMultipleChoice;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaMultipleChoice;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoiceTest {

    private String enunciado;
    private List<String> opciones;
    private Set<Integer> opcionesCorrectas;
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

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Clasico
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void test01UnaPreguntaMCCPuedeCrearseSiSeIndicanLasRtasCorretas(){
        crearMultipleChoiceClasico();
        RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice(this.opcionesCorrectas);
        assertEquals(Collections.singletonList(1), this.preguntaMC.responder(Collections.singletonList(respuesta)));
    }

    @Test
    public void test02UnaPreguntaMCCRecibeUnaListaDeRespuestasYAsignaPuntos(){
        crearMultipleChoiceClasico();
        RespuestaMultipleChoice respuestaCorrecta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(2, 0, 1)));
        RespuestaMultipleChoice respuestaIncorrecta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(4, 3)));
        assertEquals(Arrays.asList(1, 0), this.preguntaMC.responder(Arrays.asList(respuestaCorrecta, respuestaIncorrecta)));
    }

    @Test
    public void test03UnaPreguntaMCCDevuelve0SiSeRespondeIncorrectamente(){
        crearMultipleChoiceClasico();
        RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(4, 3)));
        assertEquals(Collections.singletonList(0), this.preguntaMC.responder(Collections.singletonList(respuesta)));
    }

    @Test
    public void test04UnaPreguntaMCCDevuelve0SiNoSeEnviaLaTotalidadDeRespuestasCorrectas(){
        crearMultipleChoiceClasico();
        RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(1, 0)));
        assertEquals(Collections.singletonList(0), this.preguntaMC.responder(Collections.singletonList(respuesta)));
    }

    @Test
    public void test05UnaPreguntaMCCDevuelve0SiNoEnvioNada(){
        crearMultipleChoiceClasico();
        RespuestaMultipleChoice respuestaVacia = new RespuestaMultipleChoice(new HashSet<>(Collections.emptyList()));
        assertEquals(Collections.singletonList(0), this.preguntaMC.responder(Collections.singletonList(respuestaVacia)));
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Parcial
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void test06UnaPreguntaMCPAPuedeCrearseSiSeIndicanLasRtasCorretas(){
        crearMultipleChoiceParcial();
        RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(2, 1, 0)));
        assertEquals(Collections.singletonList(3), this.preguntaMC.responder(Collections.singletonList(respuesta)));
    }

    @Test
    public void test07UnaPreguntaMCPARecibeUnaListaDeRespuestasYAsignaPuntos(){
        crearMultipleChoiceParcial();
        RespuestaMultipleChoice respuestaCorrecta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(2, 1, 0)));
        RespuestaMultipleChoice respuestaIncorrecta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(4, 1, 3)));
        assertEquals(Arrays.asList(3, 0), this.preguntaMC.responder(Arrays.asList(respuestaCorrecta, respuestaIncorrecta)));
    }

    @Test
    public void test08UnaPreguntaMCPADevuelve2ConDosRespuestasCorrectas(){
        crearMultipleChoiceParcial();
        RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(2, 0)));
        assertEquals(Collections.singletonList(2), this.preguntaMC.responder(Collections.singletonList(respuesta)));
    }

    @Test
    public void test09UnaPreguntaMCPADevuelve0ConTresRespuestasCorrectasYUnaIncorrecta(){
        crearMultipleChoiceParcial();
        RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(2, 0, 1, 3)));
        assertEquals(Collections.singletonList(0), this.preguntaMC.responder(Collections.singletonList(respuesta)));
    }

    @Test
    public void test10UnaPreguntaMCPADevuelve0SiNoEnvioNada(){
        crearMultipleChoiceParcial();
        RespuestaMultipleChoice respuestaVacia = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList()));
        assertEquals(Collections.singletonList(0), this.preguntaMC.responder(Collections.singletonList(respuestaVacia)));
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Penalidad
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void test11UnaPreguntaMCPEPuedeCrearseSiSeIndicanLasRtasCorretas(){
        crearMultipleChoicePenalidad();
        RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(2, 0, 1)));
        assertEquals(Collections.singletonList(3), this.preguntaMC.responder(Collections.singletonList(respuesta)));
    }

    @Test
    public void test12UnaPreguntaMCPERecibeUnaListaDeRespuestasYAsignaPuntos(){
        crearMultipleChoicePenalidad();
        RespuestaMultipleChoice respuestaCorrecta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(2, 0, 1)));
        RespuestaMultipleChoice respuestaIncorrecta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(2, 4, 1)));
        assertEquals(Arrays.asList(3, 1), this.preguntaMC.responder(Arrays.asList(respuestaCorrecta, respuestaIncorrecta)));
    }


    @Test
    public void test13UnaPreguntaMCPEDevuelve2ConDosRespuestasCorrectas(){
        crearMultipleChoicePenalidad();
        RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(2, 0)));
        assertEquals(Collections.singletonList(2), this.preguntaMC.responder(Collections.singletonList(respuesta)));
    }

    @Test
    public void test14UnaPreguntaMCPEDevuelve2ConTresRespuestasCorrectasYUnaIncorrecta(){
        crearMultipleChoicePenalidad();
        RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList(2, 0, 1, 4)));
        assertEquals(Collections.singletonList(2), this.preguntaMC.responder(Collections.singletonList(respuesta)));
    }

    @Test
    public void test15UnaPreguntaMCPEDevuelve0SiNoEnvioNada(){
        crearMultipleChoicePenalidad();
        RespuestaMultipleChoice respuestaVacia = new RespuestaMultipleChoice(new HashSet<>(Collections.emptyList()));
        assertEquals(Collections.singletonList(0), this.preguntaMC.responder(Collections.singletonList(respuestaVacia)));
    }

    @Test
    public void test16UnaPreguntaMCPEDevuelveMenos1SiEnvioRespuestaIncorrecta(){
        crearMultipleChoicePenalidad();
        RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice(new HashSet<>(Collections.singletonList(4)));
        assertEquals(Collections.singletonList(-1), this.preguntaMC.responder(Collections.singletonList(respuesta)));
    }

}