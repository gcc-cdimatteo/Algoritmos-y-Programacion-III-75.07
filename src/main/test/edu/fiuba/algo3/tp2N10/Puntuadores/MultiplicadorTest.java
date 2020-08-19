package edu.fiuba.algo3.tp2N10.Puntuadores;

import edu.fiuba.algo3.tp2N10.Modelo.Puntuadores.Multiplicador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MultiplicadorTest {

    @Test
    public void test01MultiplicadorPorDosIncrementaElPuntaje() {
        Multiplicador miMultiplicador = Multiplicador.PorDos();
        assertEquals(10, miMultiplicador.multiplicar(5));
    }

    @Test
    public void test02MultiplicadorNoSePuedeUsarDosVeces() {
        Multiplicador miMultiplicador = Multiplicador.PorTres();
        miMultiplicador.multiplicar(5);
        assertFalse(miMultiplicador.estaDisponible());
    }

    @Test
    public void test03MultiplicadorNuloSigueDisponibleLuegoDeUsarlo() {
        Multiplicador miMultiplicador = Multiplicador.Nulo();
        miMultiplicador.multiplicar(1);
        assertTrue(miMultiplicador.estaDisponible());
    }

}
