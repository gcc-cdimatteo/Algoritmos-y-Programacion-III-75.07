package edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot;

import edu.fiuba.algo3.tp2N10.Modelo.Excepciones.PowerUpNoDisponibleException;
import edu.fiuba.algo3.tp2N10.Modelo.Puntuadores.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Jugador {

    private String nombre;
    private int puntaje = 0;
    private List<Multiplicador> multiplicadores = Arrays.asList(new Multiplicador(1), new Multiplicador(2), new Multiplicador(3));
    private Multiplicador multiplicadorActual = multiplicadores.get(0);
    private int usosDisponiblesExclusividad = 2;
    private Jugador proximoJugador;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public static Jugador ingresarJugadores(List<Jugador> jugadores) {
        Jugador miPrimerJugador = jugadores.get(0);
        Jugador miSegundoJugador = jugadores.get(1);
        miPrimerJugador.proximoJugador = miSegundoJugador;
        return miPrimerJugador;
    }

    public Jugador jugadorActual() {
        return this;
    }

    public Jugador proximoJugador() {
        Jugador proximo = this.proximoJugador;
        this.proximoJugador = this;
        return proximo;
    }

    public String nombre() {
        return nombre;
    }

    //Me sirve mas asi que pasandolo por constructor, para hacer un setup de main y despues solo asignarle nombres con un controlador
    public void nombrar(String nombre) {
        this.nombre = nombre;
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
