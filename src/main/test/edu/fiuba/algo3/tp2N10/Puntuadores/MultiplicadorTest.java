package edu.fiuba.algo3.tp2N10.Puntuadores;

import edu.fiuba.algo3.tp2N10.Modelo.Excepciones.PowerUpNoDisponibleException;
import edu.fiuba.algo3.tp2N10.Modelo.Puntuadores.Multiplicador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MultiplicadorTest {

    @Test
    public void test01MultiplicadorPorDosDuplicaElPuntaje() {
        Multiplicador miMultiplicador = Multiplicador.PorDos();
        assertEquals(10, miMultiplicador.multiplicar(5));
    }

    @Test
    public void test02MultiplicadorNuevoEstaDisponible() {
        Multiplicador miMultiplicador = Multiplicador.PorDos();
        assertTrue(miMultiplicador.estaDisponible());
    }

    @Test
    public void test03MultiplicadorPorDosNoEstaDisponibleLuegoDeUsarlo() {
        Multiplicador miMultiplicador = Multiplicador.PorDos();
        miMultiplicador.multiplicar(5);
        assertFalse(miMultiplicador.estaDisponible());
    }

    @Test
    public void test04SiSeUsaUnMultiplicadorNoDisponibleLanzaUnaExcepcion() {
        Multiplicador miMultiplicador = Multiplicador.PorTres();
        miMultiplicador.multiplicar(5);
        assertFalse(miMultiplicador.estaDisponible());
        assertThrows(PowerUpNoDisponibleException.class, () -> miMultiplicador.multiplicar(2));
    }

    @Test
    public void test05MultiplicadorNuloSigueDisponibleLuegoDeUsarlo() {
        Multiplicador miMultiplicador = Multiplicador.Nulo();
        miMultiplicador.multiplicar(1);
        assertTrue(miMultiplicador.estaDisponible());
    }

}
