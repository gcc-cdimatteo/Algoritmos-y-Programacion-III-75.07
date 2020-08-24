package edu.fiuba.algo3.tp2N10.AlgoKahoot;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Jugador;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Ronda;
import edu.fiuba.algo3.tp2N10.Modelo.Excepciones.FaltanRespuestasException;
import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.tp2N10.Modelo.Pregunta.PreguntaVerdaderoFalso;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaVerdaderoFalso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RondaTest {

    private Pregunta pregunta;
    private Jugador jugador1;
    private Jugador jugador2;
    private Ronda ronda;

    public void crearJugadores(){
        jugador1 = new Jugador("Agustin");
        jugador2 = new Jugador("Bill Gates");
        jugador1.ordenarCon(jugador2);
    }

    public void crearPreguntaVerdaderoYFalsoClasico(){
        this.pregunta = PreguntaVerdaderoFalso.Clasico("La Manzana es una fruta", true);

    }

    public void crearRonda() {
        this.ronda = new Ronda(this.pregunta, this.jugador1);
    }

    @Test
    public void test01RondaRecibeRespuestasYAsignaPuntajeCorrectamente() {
        crearJugadores();
        crearPreguntaVerdaderoYFalsoClasico();
        crearRonda();
        Respuesta respuestaJugador1 = new RespuestaVerdaderoFalso(true);
        Respuesta respuestaJugador2 = new RespuestaVerdaderoFalso(false);
        ronda.cargarRespuesta(respuestaJugador1);
        ronda.cargarRespuesta(respuestaJugador2);
        ronda.asignarPuntos();

        assertEquals(1, jugador1.puntaje());
        assertEquals(0, jugador2.puntaje());
    }

    @Test
    public void test02SiNoHayRespuestasAlAsignarPuntosRondaLanzaUnaExcepcion() {
        crearJugadores();
        crearPreguntaVerdaderoYFalsoClasico();
        crearRonda();
        assertThrows(FaltanRespuestasException.class, ronda::asignarPuntos);
    }

    @Test
    public void test03SiFaltaUnaRespuestaAlAsignarPuntosRondaLanzaUnaExcepcion() {
        crearJugadores();
        crearPreguntaVerdaderoYFalsoClasico();
        crearRonda();
        Respuesta respuestaJugador1 = new RespuestaVerdaderoFalso(true);
        ronda.cargarRespuesta(respuestaJugador1);
        assertThrows(FaltanRespuestasException.class, ronda::asignarPuntos);
    }

}
