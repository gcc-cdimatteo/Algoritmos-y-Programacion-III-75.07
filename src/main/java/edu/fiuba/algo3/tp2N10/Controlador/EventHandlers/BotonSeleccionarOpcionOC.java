package edu.fiuba.algo3.tp2N10.Controlador.EventHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.List;

public class BotonSeleccionarOpcionOC implements EventHandler<ActionEvent> {
    private final Button boton;
    private final int numeroOpcion;
    private final HandlerOpcionesOC handlerOpciones;

    public BotonSeleccionarOpcionOC(Button boton, int numeroOpcion, HandlerOpcionesOC handlerOpciones) {
        this.boton = boton;
        this.numeroOpcion = numeroOpcion;
        this.handlerOpciones = handlerOpciones;
    }

    public void agregarARespuesta(List<Integer> respuestaUsuario) {
        respuestaUsuario.add(numeroOpcion);
    }

    public void agregarBotonA(List<Button> botones) {
        botones.add(boton);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        boton.setVisible(false);
        handlerOpciones.agregar(this);
    }
}