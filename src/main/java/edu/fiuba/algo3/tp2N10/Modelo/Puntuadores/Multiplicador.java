package edu.fiuba.algo3.tp2N10.Modelo.Puntuadores;

import edu.fiuba.algo3.tp2N10.Modelo.Excepciones.PowerUpNoDisponibleException;

public class Multiplicador {

    private int valor;
    private int usosDisponibles;

    public static Multiplicador Nulo() {
        Multiplicador miMultiplicador = new Multiplicador();
        miMultiplicador.valor = 1;
        miMultiplicador.usosDisponibles = -1;
        return miMultiplicador;
    }

    public static Multiplicador PorDos() {
        Multiplicador miMultiplicador = new Multiplicador();
        miMultiplicador.valor = 2;
        miMultiplicador.usosDisponibles = 1;
        return miMultiplicador;
    }

    public static Multiplicador PorTres() {
        Multiplicador miMultiplicador = new Multiplicador();
        miMultiplicador.valor = 3;
        miMultiplicador.usosDisponibles = 1;
        return miMultiplicador;
    }

    public Integer multiplicar(Integer unPuntaje) {
        if (!estaDisponible()) throw new PowerUpNoDisponibleException();
        usosDisponibles--;
        return valor * unPuntaje;
    }

    public boolean estaDisponible() {
        return usosDisponibles != 0;
    }
}
