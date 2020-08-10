package edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot;

import edu.fiuba.algo3.tp2N10.Modelo.Excepciones.PowerUpNoDisponibleException;
import edu.fiuba.algo3.tp2N10.Modelo.Puntuadores.*;

import java.util.Arrays;
import java.util.List;

public class Jugador {

    private final String nombre;
    private int puntaje = 0;
    private List<Multiplicador> multiplicadores = Arrays.asList(new Multiplicador(1), new Multiplicador(2), new Multiplicador(3));
    private Multiplicador multiplicadorActual = multiplicadores.get(0);
    private int usosDisponiblesExclusividad = 2;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public String nombre() {
        return nombre;
    }

    public void puntuar(int puntos) {
        puntaje += multiplicadorActual.multiplicar(puntos);
        multiplicadorActual = multiplicadores.get(0);
    }

    public int puntaje() {
        return puntaje;
    }

    public void usarMultiplicador(int valor) {
        Multiplicador multiplicador = multiplicadores.get(valor - 1);
        multiplicador.usar();
        multiplicadorActual = multiplicador;
    }

    public void usarExclusividad() {
        if (usosDisponiblesExclusividad == 0) throw new PowerUpNoDisponibleException();
        usosDisponiblesExclusividad -= 1;
    }
}
