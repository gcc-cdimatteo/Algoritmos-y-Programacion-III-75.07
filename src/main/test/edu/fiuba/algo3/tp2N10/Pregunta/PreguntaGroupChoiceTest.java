package edu.fiuba.algo3.tp2N10.Pregunta;

import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.PreguntaGroupChoice;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaGroupChoice;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaGroupChoiceTest {

    private final Set<Integer> opcionesGrupoA;
    private final Set<Integer> opcionesGrupoB;
    private final PreguntaGroupChoice preguntaGC;

    public PreguntaGroupChoiceTest(){
        String enunciado = "Ordene las opciones en los grupos correctos...";
        List<String> opciones = Arrays.asList("A", "1", "B", "2");
        this.opcionesGrupoA = new HashSet<>(Arrays.asList(0, 2));
        this.opcionesGrupoB = new HashSet<>(Arrays.asList(1, 3));
        this.preguntaGC = new PreguntaGroupChoice(enunciado, opciones, opcionesGrupoA, opcionesGrupoB);
    }

    @Test
    public void test01UnaPreguntaGCPuedeCrearseSiSeIndicanLasRtasCorretas() {
        RespuestaGroupChoice respuestaCorrecta = new RespuestaGroupChoice(this.opcionesGrupoA, this.opcionesGrupoB);
        assertEquals(Collections.singletonList(1), this.preguntaGC.responder(Collections.singletonList(respuestaCorrecta)));
    }

    @Test
    public void test02UnaPreguntaGCPuntua0SiSeRespondeMal() {
        RespuestaGroupChoice unaRespuesta = new RespuestaGroupChoice(new HashSet<>(Arrays.asList(0, 1)), new HashSet<>(Arrays.asList(3, 2)));
        assertEquals(Collections.singletonList(0), this.preguntaGC.responder(Collections.singletonList(unaRespuesta)));
    }

    @Test
    public void test03UnaPreguntaGCPuntua1SiSeAgrupaBienPeroDesordenado() {
        RespuestaGroupChoice unaRespuesta = new RespuestaGroupChoice(new HashSet<>(Arrays.asList(2, 0)), new HashSet<>(Arrays.asList(1, 3)));
        assertEquals(Collections.singletonList(1), this.preguntaGC.responder(Collections.singletonList(unaRespuesta)));
    }

    @Test
    public void test04UnaPreguntaGCRecibeUnaListaDeRespuestasYAsignaPuntos() {
        Set<Integer> opcionesGrupoC = new HashSet<>(Arrays.asList(0, 1));
        Set<Integer> opcionesGrupoD = new HashSet<>(Arrays.asList(2, 3));
        RespuestaGroupChoice respuestaCorrecta = new RespuestaGroupChoice(this.opcionesGrupoA, this.opcionesGrupoB);
        RespuestaGroupChoice respuestaIncorrecta = new RespuestaGroupChoice(opcionesGrupoC, opcionesGrupoD);
        assertEquals(Arrays.asList(1, 0), this.preguntaGC.responder(Arrays.asList(respuestaCorrecta, respuestaIncorrecta)));
    }

    @Test
    public void test05UnaPreguntaGCPuntua0SiNoSeEnviaLaTotalidadDeIntegrantesEnUnGrupo() {
        RespuestaGroupChoice unaRespuesta = new RespuestaGroupChoice(new HashSet<>(Arrays.asList(0, 2)), new HashSet<>(Collections.singletonList(1)));
        assertEquals(Collections.singletonList(0), this.preguntaGC.responder(Collections.singletonList(unaRespuesta)));
    }

    @Test
    public void test06UnaPreguntaGCPuntua0SiNoEnvioNada() {
        RespuestaGroupChoice unaRespuesta = new RespuestaGroupChoice(new HashSet<>(), new HashSet<>());
        assertEquals(Collections.singletonList(0), this.preguntaGC.responder(Collections.singletonList(unaRespuesta)));
    }

}
