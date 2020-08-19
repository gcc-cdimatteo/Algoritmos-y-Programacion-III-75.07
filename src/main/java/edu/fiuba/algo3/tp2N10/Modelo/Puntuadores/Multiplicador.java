package edu.fiuba.algo3.tp2N10.Modelo.Puntuadores;

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
        usosDisponibles--;
        return unPuntaje * valor;
    }

    public boolean estaDisponible() {
        return usosDisponibles != 0;
    }
}
