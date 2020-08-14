package edu.fiuba.algo3.tp2N10;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Jugador;
import edu.fiuba.algo3.tp2N10.Modelo.Puntuadores.PuntuadorExclusividad;
import edu.fiuba.algo3.tp2N10.Modelo.Puntuadores.PuntuadorNulo;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntuadorNuloTest {

    @Test
    public void test01PuntuadorNuloNoCambiaLosPuntos() {

        List<Integer> puntos = Arrays.asList(1, 2);
        PuntuadorNulo puntuador = new PuntuadorNulo();

        assertEquals(puntos, puntuador.calcularPuntos(puntos));
    }

    @Test
    public void test02UsarExclusividadDevuelveExclusividadDePuntaje() {
        Jugador jugadorUno = new Jugador("Magnolia");
        PuntuadorNulo puntuador = new PuntuadorNulo();

        assertEquals(PuntuadorExclusividad.class, puntuador.usarExclusividad(jugadorUno).getClass());
    }
}
