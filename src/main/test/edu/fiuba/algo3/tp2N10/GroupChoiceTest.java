package edu.fiuba.algo3.tp2N10;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupChoiceTest {

    @Test
    public void GroupChoicePuedeCrearseSiSeIndicanLasRtasCorretas() {
        HashSet<String> grupoLetras = new HashSet<>(Arrays.asList("A", "B"));
        HashSet<String> grupoNumeros = new HashSet<>(Arrays.asList("1", "2"));
        RespuestaGroupChoice respuestaCorrecta = new RespuestaGroupChoice(grupoLetras, grupoNumeros);
        GroupChoice preguntaGC = new GroupChoice("Ordene las opciones en los grupos correctos...", respuestaCorrecta);
        assertEquals(Collections.singletonList(1), preguntaGC.responder(new ArrayList<>(Collections.singletonList(respuestaCorrecta))));
    }

    @Test
    public void GroupChoiceRecibeUnaListaDeRespuestasYAsignaPuntos() {
        HashSet<String> grupoNumeros = new HashSet<>(Arrays.asList("A", "B"));
        HashSet<String> grupoLetras = new HashSet<>(Arrays.asList("1", "2"));

        RespuestaGroupChoice respuestaCorrecta = new RespuestaGroupChoice(grupoNumeros, grupoLetras);
        RespuestaGroupChoice respuestaIncorrecta = new RespuestaGroupChoice(grupoLetras, grupoNumeros);

        GroupChoice preguntaGC = new GroupChoice("Ordene las opciones en los grupos correctos...", respuestaCorrecta);
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 0));
        assertEquals(expected, preguntaGC.responder(Arrays.asList(respuestaCorrecta, respuestaIncorrecta)));
    }
}
