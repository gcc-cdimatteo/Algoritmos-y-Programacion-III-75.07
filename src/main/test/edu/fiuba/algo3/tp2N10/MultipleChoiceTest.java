package edu.fiuba.algo3.tp2N10;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleChoiceTest {

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Clasico
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void MultipleChoiceClasicoPuedeCrearseSiSeIndicanLasRtasCorretas(){
        MultipleChoice preguntaMC = new MultipleChoice("La manzana es...", new RespuestaMultipleChoice(new HashSet<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta"))));
        assertEquals(new ArrayList<>(Arrays.asList(1)), preguntaMC.responder(new ArrayList<>(Arrays.asList(new RespuestaMultipleChoice(new HashSet<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta")))))));
    }

    @Test
    public void MultipleChoiceClasicoRecibeUnaListaDeRespuestasYAsignaPuntos(){
        MultipleChoice preguntaMC = new MultipleChoice("La manzana es...", new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta")));
        assertEquals(new ArrayList<>(Arrays.asList(1, 0)), preguntaMC.responderLista(new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta")), new ArrayList<>(Arrays.asList("Es Rica", "Es Carne", "Es Una Fruta"))))));
    }

    @Test
    public void MultipleChoiceClasicoDevuelve0SiSeRespondeIncorrectamente(){
        MultipleChoice preguntaMC = new MultipleChoice("La manzana es...", new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta")));
        assertEquals(0, preguntaMC.responder(new ArrayList<>(Arrays.asList("Es Rica", "Es Carne", "Es Una Fruta"))));
    }

    @Test
    public void MultipleChoiceClasicoDevuelve0SiNoSeEnviaLaTotalidadDeRespuestasCorrectas(){
        MultipleChoice preguntaMC = new MultipleChoice("La manzana es...", new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta")));
        assertEquals(0, preguntaMC.responder(new ArrayList<>(Arrays.asList("Es Rica", "Es Una Fruta"))));
    }

    @Test
    public void MultipleChoiceClasicoDevuelve0SiSeEnvianTodasLasRespuestasCorrectasYUnaIncorrecta(){
        MultipleChoice preguntaMC = new MultipleChoice("La manzana es...", new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta")));
        assertEquals(0, preguntaMC.responder(new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta", "Es Carne"))));
    }

    @Test
    public void MultipleChoiceClasicoDevuelve0SiNoEnvioNada(){
        MultipleChoice preguntaMC = new MultipleChoice("La manzana es...", new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta")));
        assertEquals(0, preguntaMC.responder(new ArrayList<>()));
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Parcial
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void MultipleChoiceParcialPuedeCrearseSiSeIndicanLasRtasCorretas(){
        MultipleChoice preguntaMC = MultipleChoice.MultipleChoiceParcial("La manzana es...", new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta")));
        assertEquals(3, preguntaMC.responder(new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta"))));
    }

    @Test
    public void MultipleChoiceParcialRecibeUnaListaDeRespuestasYAsignaPuntos(){
        MultipleChoice preguntaMC = MultipleChoice.MultipleChoiceParcial("La manzana es...", new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta")));
        assertEquals(new ArrayList<>(Arrays.asList(3, 0)), preguntaMC.responderLista(new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta")), new ArrayList<>(Arrays.asList("Es Rica", "Es Carne", "Es Una Fruta"))))));
    }

    @Test
    public void MultipleChoiceParcialDevuelve0ConUnaRespuestaIncorrectaYDosCorrectas(){
        MultipleChoice preguntaMC = MultipleChoice.MultipleChoiceParcial("La manzana es...", new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta")));
        assertEquals(0, preguntaMC.responder(new ArrayList<>(Arrays.asList("Es Rica", "Es Carne", "Es Una Fruta"))));
    }

    @Test
    public void MultipleChoiceParcialDevuelve2ConDosRespuestasCorrectas(){
        MultipleChoice preguntaMC = MultipleChoice.MultipleChoiceParcial("La manzana es...", new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta")));
        assertEquals(2, preguntaMC.responder(new ArrayList<>(Arrays.asList("Es Rica", "Es Una Fruta"))));
    }

    @Test
    public void MultipleChoiceParcialDevuelve0ConTresRespuestasCorrectasYUnaIncorrecta(){
        MultipleChoice preguntaMC = MultipleChoice.MultipleChoiceParcial("La manzana es...", new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta")));
        assertEquals(0, preguntaMC.responder(new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta", "Es Carne"))));
    }

    @Test
    public void MultipleChoiceParcialDevuelve0SiNoEnvioNada(){
        MultipleChoice preguntaMC = MultipleChoice.MultipleChoiceParcial("La manzana es...", new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta")));
        assertEquals(0, preguntaMC.responder(new ArrayList<>()));
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Penalidad
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void MultipleChoicePenalidadPuedeCrearseSiSeIndicanLasRtasCorretas(){
        MultipleChoice preguntaMC = MultipleChoice.MultipleChoicePenalidad("La manzana es...", new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta")));
        assertEquals(3, preguntaMC.responder(new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta"))));
    }

    @Test
    public void MultipleChoicePenalidadRecibeUnaListaDeRespuestasYAsignaPuntos(){
        MultipleChoice preguntaMC = MultipleChoice.MultipleChoicePenalidad("La manzana es...", new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta")));
        assertEquals(new ArrayList<>(Arrays.asList(3, 1)), preguntaMC.responderLista(new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta")), new ArrayList<>(Arrays.asList("Es Rica", "Es Carne", "Es Una Fruta"))))));
    }


    @Test
    public void MultipleChoicePenalidadDevuelve2ConUnaRespuestaIncorrectaYDosCorrectas(){
        MultipleChoice preguntaMC = MultipleChoice.MultipleChoicePenalidad("La manzana es...", new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta")));
        assertEquals(1, preguntaMC.responder(new ArrayList<>(Arrays.asList("Es Rica", "Es Carne", "Es Una Fruta"))));
    }

    @Test
    public void MultipleChoicePenalidadDevuelve2ConDosRespuestasCorrectas(){
        MultipleChoice preguntaMC = MultipleChoice.MultipleChoicePenalidad("La manzana es...", new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta")));
        assertEquals(2, preguntaMC.responder(new ArrayList<>(Arrays.asList("Es Rica", "Es Una Fruta"))));
    }

    @Test
    public void MultipleChoicePenalidadDevuelve2ConTresRespuestasCorrectasYUnaIncorrecta(){
        MultipleChoice preguntaMC = MultipleChoice.MultipleChoicePenalidad("La manzana es...", new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta")));
        assertEquals(2, preguntaMC.responder(new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta", "Es Carne"))));
    }

    @Test
    public void MultipleChoicePenalidadDevuelve0SiNoEnvioNada(){
        MultipleChoice preguntaMC = MultipleChoice.MultipleChoicePenalidad("La manzana es...", new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta")));
        assertEquals(0, preguntaMC.responder(new ArrayList<>()));
    }

    @Test
    public void MultipleChoicePenalidadDevuelveMenos2SiEnvioDosIncorrectas(){
        MultipleChoice preguntaMC = MultipleChoice.MultipleChoicePenalidad("La manzana es...", new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta")));
        assertEquals(-2, preguntaMC.responder(new ArrayList<>(Arrays.asList("Es Un Citrico", "Es Carne"))));
    }

}