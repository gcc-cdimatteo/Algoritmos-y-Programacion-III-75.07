package edu.fiuba.algo3.tp2N10;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderedChoiceTest {

    @Test
    public void MultipleChoiceClasicoPuedeCrearseSiSeIndicanLasRtasCorretas(){
        MultipleChoice preguntaMC = new MultipleChoice("La manzana es...", new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta")));
        assertEquals(1, preguntaMC.responder(new ArrayList<>(Arrays.asList("Es Rica", "Es Roja", "Es Una Fruta"))));
    }

}
