package edu.fiuba.algo3.tp2N10.Controlador.EventHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;

import java.io.File;
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
        try {
            MediaPlayer reproductor = new MediaPlayer(new Media(new File("./resources/audio/click.mp3").toURI().toString()));
            reproductor.setVolume(0.6);
            reproductor.play();
        } catch (MediaException ignored) {}
        boton.setVisible(false);
        handlerOpciones.agregar(this);
    }
}