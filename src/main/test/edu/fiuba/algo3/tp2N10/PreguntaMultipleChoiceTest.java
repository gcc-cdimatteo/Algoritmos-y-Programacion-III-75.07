package edu.fiuba.algo3.tp2N10;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoiceTest {

    private PreguntaMultipleChoice preguntaMC;
    private RespuestaMultipleChoice respuestaVacia = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList()));
    private RespuestaMultipleChoice respuestasCorrectasTres = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList("Verde", "Roja", "Una Fruta")));
    private RespuestaMultipleChoice respuestasCorrectasDos = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList("Roja", "Una Fruta")));
    private RespuestaMultipleChoice respuestasCorrectasDosRespuestasIncorrectasUno = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList("Roja", "Azul", "Una Fruta")));
    private RespuestaMultipleChoice respuestasCorrectasTresRespuestasIncorrectasUno = new RespuestaMultipleChoice(new HashSet<>(Arrays.asList("Verde", "Roja", "Una Fruta", "Azul")));
    private RespuestaMultipleChoice respuestaIncorrecta = new RespuestaMultipleChoice(new HashSet<>(Collections.singletonList("Azul")));

    private void crearMultipleChoiceClasico() {
        String enunciado = "La manzana es...";
        List<String> opcionesCorrectas = Arrays.asList("Una Fruta", "Verde", "Roja");
        List<String> opcionesIncorrectas = Arrays.asList("Azul");

        this.preguntaMC = PreguntaMultipleChoice.Clasico(enunciado, opcionesCorrectas, opcionesIncorrectas);
    }

    private void crearMultipleChoiceParcial() {
        Enunciado miEnunciado = new Enunciado("La manzana es...", Arrays.asList("Una Fruta", "Verde", "Roja", "Azul"));
        this.preguntaMC = PreguntaMultipleChoice.Parcial(miEnunciado, this.respuestasCorrectasTres);
    }

    private void crearMultipleChoicePenalidad() {
        Enunciado miEnunciado = new Enunciado("La manzana es...", Arrays.asList("Una Fruta", "Verde", "Roja", "Azul"));
        this.preguntaMC = PreguntaMultipleChoice.Penalidad(miEnunciado, this.respuestasCorrectasTres);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Clasico
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void MultipleChoiceClasicoPuedeCrearseSiSeIndicanLasRtasCorretas(){
        crearMultipleChoiceClasico();
        assertEquals(Collections.singletonList(1), this.preguntaMC.responder(Collections.singletonList(this.respuestasCorrectasTres)));
    }

    @Test
    public void MultipleChoiceClasicoRecibeUnaListaDeRespuestasYAsignaPuntos(){
        crearMultipleChoiceClasico();
        assertEquals(Arrays.asList(1, 0), this.preguntaMC.responder(Arrays.asList(this.respuestasCorrectasTres, this.respuestasCorrectasDosRespuestasIncorrectasUno)));
    }

    @Test
    public void MultipleChoiceClasicoDevuelve0SiSeRespondeIncorrectamente(){
        crearMultipleChoiceClasico();
        assertEquals(Collections.singletonList(0), this.preguntaMC.responder(Collections.singletonList(this.respuestasCorrectasDosRespuestasIncorrectasUno)));
    }

    @Test
    public void MultipleChoiceClasicoDevuelve0SiNoSeEnviaLaTotalidadDeRespuestasCorrectas(){
        crearMultipleChoiceClasico();
        assertEquals(Collections.singletonList(0), this.preguntaMC.responder(Collections.singletonList(this.respuestasCorrectasDos)));
    }

    @Test
    public void MultipleChoiceClasicoDevuelve0SiNoEnvioNada(){
        crearMultipleChoiceClasico();
        assertEquals(Collections.singletonList(0), this.preguntaMC.responder(Collections.singletonList(this.respuestaVacia)));
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Parcial
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void MultipleChoiceParcialPuedeCrearseSiSeIndicanLasRtasCorretas(){
        crearMultipleChoiceParcial();
        assertEquals(Collections.singletonList(3), this.preguntaMC.responder(Collections.singletonList(this.respuestasCorrectasTres)));
    }

    @Test
    public void MultipleChoiceParcialRecibeUnaListaDeRespuestasYAsignaPuntos(){
        crearMultipleChoiceParcial();
        assertEquals(Arrays.asList(3, 0), this.preguntaMC.responder(Arrays.asList(this.respuestasCorrectasTres, this.respuestasCorrectasDosRespuestasIncorrectasUno)));
    }

    @Test
    public void MultipleChoiceParcialDevuelve2ConDosRespuestasCorrectas(){
        crearMultipleChoiceParcial();
        assertEquals(Collections.singletonList(2), this.preguntaMC.responder(Collections.singletonList(this.respuestasCorrectasDos)));
    }

    @Test
    public void MultipleChoiceParcialDevuelve0ConTresRespuestasCorrectasYUnaIncorrecta(){
        crearMultipleChoiceParcial();
        assertEquals(Collections.singletonList(0), this.preguntaMC.responder(Collections.singletonList(this.respuestasCorrectasTresRespuestasIncorrectasUno)));
    }

    @Test
    public void MultipleChoiceParcialDevuelve0SiNoEnvioNada(){
        crearMultipleChoiceParcial();
        assertEquals(Collections.singletonList(0), this.preguntaMC.responder(Collections.singletonList(this.respuestaVacia)));
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Penalidad
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void MultipleChoicePenalidadPuedeCrearseSiSeIndicanLasRtasCorretas(){
        crearMultipleChoicePenalidad();
        assertEquals(Collections.singletonList(3), this.preguntaMC.responder(Collections.singletonList(this.respuestasCorrectasTres)));
    }

    @Test
    public void MultipleChoicePenalidadRecibeUnaListaDeRespuestasYAsignaPuntos(){
        crearMultipleChoicePenalidad();
        assertEquals(Arrays.asList(3, 2), this.preguntaMC.responder(Arrays.asList(this.respuestasCorrectasTres, this.respuestasCorrectasTresRespuestasIncorrectasUno)));
    }


    @Test
    public void MultipleChoicePenalidadDevuelve2ConDosRespuestasCorrectas(){
        crearMultipleChoicePenalidad();
        assertEquals(Collections.singletonList(2), this.preguntaMC.responder(Collections.singletonList(this.respuestasCorrectasDos)));
    }

    @Test
    public void MultipleChoicePenalidadDevuelve2ConTresRespuestasCorrectasYUnaIncorrecta(){
        crearMultipleChoicePenalidad();
        assertEquals(Collections.singletonList(2), this.preguntaMC.responder(Collections.singletonList(this.respuestasCorrectasTresRespuestasIncorrectasUno)));
    }

    @Test
    public void MultipleChoicePenalidadDevuelve0SiNoEnvioNada(){
        crearMultipleChoicePenalidad();
        assertEquals(Collections.singletonList(0), this.preguntaMC.responder(Collections.singletonList(this.respuestaVacia)));
    }

    @Test
    public void MultipleChoicePenalidadDevuelveMenos1SiEnvioRespuestaIncorrecta(){
        crearMultipleChoicePenalidad();
        assertEquals(Collections.singletonList(-1), this.preguntaMC.responder(Collections.singletonList(this.respuestaIncorrecta)));
    }

}