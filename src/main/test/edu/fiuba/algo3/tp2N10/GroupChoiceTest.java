package edu.fiuba.algo3.tp2N10;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupChoiceTest {

    private final HashSet<String> grupoLetras = new HashSet<>(Arrays.asList("A", "B"));
    private final HashSet<String> grupoNumeros = new HashSet<>(Arrays.asList("1", "2"));
    private final RespuestaGroupChoice respuestaCorrecta = new RespuestaGroupChoice(this.grupoLetras, this.grupoNumeros);
    private final RespuestaGroupChoice respuestaIncorrecta = new RespuestaGroupChoice(this.grupoNumeros, this.grupoLetras);
    private final Enunciado miEnunciado = new Enunciado("Ordene las opciones en los grupos correctos...", Arrays.asList("A", "B", "1", "2"));
    private final GroupChoice preguntaGC = new GroupChoice(miEnunciado, this.respuestaCorrecta);

    @Test
    public void GroupChoicePuedeCrearseSiSeIndicanLasRtasCorretas() {
        assertEquals(Collections.singletonList(1), this.preguntaGC.responder(new ArrayList<>(Collections.singletonList(this.respuestaCorrecta))));
    }

    @Test
    public void GroupChoiceRecibeUnaListaDeRespuestasYAsignaPuntos() {
        assertEquals(Arrays.asList(1, 0), this.preguntaGC.responder(Arrays.asList(this.respuestaCorrecta, this.respuestaIncorrecta)));
    }
}
