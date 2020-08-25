package edu.fiuba.algo3.tp2N10.Controlador.EventHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class HandlerOpcionesOC implements EventHandler<ActionEvent> {

    private final LinkedList<Button> botones = new LinkedList<>();
    private final LinkedList<Integer> respuestaUsuario;
    private final Label labelRespuesta;

    public HandlerOpcionesOC(Label respuestaOrdenadaLabel, LinkedList<Integer> respuestaOrdenada) {
        labelRespuesta = respuestaOrdenadaLabel;
        this.respuestaUsuario = respuestaOrdenada;
    }

    private void actualizarLabel() {
        StringBuilder respuestaOrdenada = new StringBuilder();
        for (int i = 0; i < botones.size(); i++) {
            respuestaOrdenada.append(String.format("%d - %s\n", i + 1, botones.get(i).getText()));
        }
        labelRespuesta.setText(respuestaOrdenada.toString());
    }

    public void agregar(BotonSeleccionarOpcionOC handler) {
        handler.agregarARespuesta(respuestaUsuario);
        handler.agregarBotonA(botones);
        actualizarLabel();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            MediaPlayer reproductor = new MediaPlayer(new Media(new File("./resources/audio/click.mp3").toURI().toString()));
            reproductor.setVolume(0.6);
            reproductor.play();
        } catch (MediaException ignored) {}
        try {
            Button boton = botones.removeLast();
            respuestaUsuario.removeLast();
            boton.setVisible(true);
            actualizarLabel();
        } catch (NoSuchElementException ignored) {}
    }
}
