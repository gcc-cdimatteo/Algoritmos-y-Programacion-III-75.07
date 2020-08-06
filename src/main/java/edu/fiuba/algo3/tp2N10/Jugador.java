package edu.fiuba.algo3.tp2N10;

import java.util.Arrays;
import java.util.List;

public class Jugador {

    private final String nombre;
    private int puntaje = 0;
    private Multiplicador multiplicadorActual = new Multiplicador(1);
    private List<Multiplicador> multiplicadores = Arrays.asList(new Multiplicador(2), new Multiplicador(3));

    public Jugador(String nombre){
        this.nombre = nombre;
    }

    public String nombre() {
        return this.nombre;
    }

    public void puntuar(int puntos) {

        try {
            puntos += multiplicadorActual.multiplicar(puntos);
        } catch (MultiplicadorUsadoException e) {}
        this.puntaje += puntos;
    }

    public int puntaje() {
        return this.puntaje;
    }


    public void usarMultiplicador(int valor) {
        this.multiplicadorActual = multiplicadores.get(valor - 2);
    }
}
