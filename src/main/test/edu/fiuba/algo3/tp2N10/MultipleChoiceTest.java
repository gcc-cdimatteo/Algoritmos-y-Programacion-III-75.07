package edu.fiuba.algo3.tp2N10;

import com.sun.javafx.runtime.async.AbstractRemoteResource;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleChoiceTest {

    @Test
    public void MultipleChoiceClasicoPuedeCrearseSiSeIndicanLasRtasCorretas(){
        MultipleChoice preguntaMC = new MultipleChoice("La manzana es...", new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta")));
        assertEquals(1, preguntaMC.responder(new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta"))));
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

    @Test
    public void MultipleChoiceParcialPuedeCrearseSiSeIndicanLasRtasCorretas(){
        MultipleChoice preguntaMC = new MultipleChoice("La manzana es...", new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta")));
        preguntaMC.parcial();
        assertEquals(3, preguntaMC.responder(new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta"))));
    }

    @Test
    public void MultipleChoiceParcialDevuelve0ConUnaRespuestaIncorrectaYDosCorrectas(){
        MultipleChoice preguntaMC = new MultipleChoice("La manzana es...", new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta")));
        preguntaMC.parcial();
        assertEquals(0, preguntaMC.responder(new ArrayList<>(Arrays.asList("Es Rica", "Es Carne", "Es Una Fruta"))));
    }

    @Test
    public void MultipleChoiceParcialDevuelve2ConDosRespuestasCorrectas(){
        MultipleChoice preguntaMC = new MultipleChoice("La manzana es...", new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta")));
        preguntaMC.parcial();
        assertEquals(2, preguntaMC.responder(new ArrayList<>(Arrays.asList("Es Rica", "Es Una Fruta"))));
    }

    @Test
    public void MultipleChoiceParcialDevuelve0ConTresRespuestasCorrectasYUnaIncorrecta(){
        MultipleChoice preguntaMC = new MultipleChoice("La manzana es...", new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta")));
        preguntaMC.parcial();
        assertEquals(0, preguntaMC.responder(new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta", "Es Carne"))));
    }

    @Test
    public void MultipleChoiceParcialDevuelve0SiNoEnvioNada(){
        MultipleChoice preguntaMC = new MultipleChoice("La manzana es...", new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta")));
        preguntaMC.parcial();
        assertEquals(0, preguntaMC.responder(new ArrayList<>()));
    }

    @Test
    public void MultipleChoicePenalidadPuedeCrearseSiSeIndicanLasRtasCorretas(){
        MultipleChoice preguntaMC = new MultipleChoice("La manzana es...", new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta")));
        preguntaMC.conPenalidad();
        assertEquals(3, preguntaMC.responder(new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta"))));
    }

    @Test
    public void MultipleChoicePenalidadDevuelve2ConUnaRespuestaIncorrectaYDosCorrectas(){
        MultipleChoice preguntaMC = new MultipleChoice("La manzana es...", new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta")));
        preguntaMC.conPenalidad();
        assertEquals(1, preguntaMC.responder(new ArrayList<>(Arrays.asList("Es Rica", "Es Carne", "Es Una Fruta"))));
    }

    @Test
    public void MultipleChoicePenalidadDevuelve2ConDosRespuestasCorrectas(){
        MultipleChoice preguntaMC = new MultipleChoice("La manzana es...", new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta")));
        preguntaMC.conPenalidad();
        assertEquals(2, preguntaMC.responder(new ArrayList<>(Arrays.asList("Es Rica", "Es Una Fruta"))));
    }

    @Test
    public void MultipleChoicePenalidadDevuelve2ConTresRespuestasCorrectasYUnaIncorrecta(){
        MultipleChoice preguntaMC = new MultipleChoice("La manzana es...", new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta")));
        preguntaMC.conPenalidad();
        assertEquals(2, preguntaMC.responder(new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta", "Es Carne"))));
    }

    @Test
    public void MultipleChoicePenalidadDevuelve0SiNoEnvioNada(){
        MultipleChoice preguntaMC = new MultipleChoice("La manzana es...", new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta")));
        preguntaMC.conPenalidad();
        assertEquals(0, preguntaMC.responder(new ArrayList<>()));
    }

    @Test
    public void MultipleChoicePenalidadDevuelveMenos2SiEnvioDosIncorrectas(){
        MultipleChoice preguntaMC = new MultipleChoice("La manzana es...", new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta")));
        preguntaMC.conPenalidad();
        assertEquals(-2, preguntaMC.responder(new ArrayList<>(Arrays.asList("Es Un Citrico", "Es Carne"))));
    }

}